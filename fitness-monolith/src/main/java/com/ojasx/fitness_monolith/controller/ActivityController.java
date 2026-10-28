package com.ojasx.fitness_monolith.controller;

import com.ojasx.fitness_monolith.dto.ActivityRequest;
import com.ojasx.fitness_monolith.dto.ActivityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @PostMapping("")
    public ResponseEntity<List<ActivityResponse>> trackActivity(@RequestBody ActivityRequest request){
        return "";
    }
}
