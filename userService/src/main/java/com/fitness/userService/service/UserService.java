package com.fitness.userService.service;

import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.model.User;
import com.fitness.userService.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponse register(@Valid RegisterRequest request) {

        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastname(request.getLastName());

        User savedUser = repository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setLastname(savedUser.getLastname());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());

        return userResponse;
    }

    public UserResponse getUserProfile(String userId) {
        User user = repository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found!"));

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setPassword(user.getPassword());
        userResponse.setLastname(user.getLastname());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }
}
