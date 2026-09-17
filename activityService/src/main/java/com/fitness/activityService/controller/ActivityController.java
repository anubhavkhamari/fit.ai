package com.fitness.activityService.controller;

import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest req){
        return ResponseEntity.ok(activityService.trackActivity(req));
    }
}
