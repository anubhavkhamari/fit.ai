package com.fitness.activityService.dto;

import com.fitness.activityService.model.ActivityType;
import lombok.Data;

import java.util.Map;

@Data
public class ActivityRequest {
    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private Map<String, Object> additionalMatrix;
}
