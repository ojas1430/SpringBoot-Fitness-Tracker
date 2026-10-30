package com.ojasx.fitness_monolith.service;

import com.ojasx.fitness_monolith.dto.RecommendatinoRequest;
import com.ojasx.fitness_monolith.model.Activity;
import com.ojasx.fitness_monolith.model.Recommendation;
import com.ojasx.fitness_monolith.model.User;
import com.ojasx.fitness_monolith.repository.ActivityRepository;
import com.ojasx.fitness_monolith.repository.RecommendationRepository;
import com.ojasx.fitness_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation(RecommendatinoRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("user not found"));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new RuntimeException("activity not found"));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
