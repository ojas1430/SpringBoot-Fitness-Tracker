package com.ojasx.fitness_monolith.controller;

import com.ojasx.fitness_monolith.dto.ActivityRequest;
import com.ojasx.fitness_monolith.dto.ActivityResponse;
import com.ojasx.fitness_monolith.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(Collections.singletonList(activityService.trackActivity(request)));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader(value = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

}
