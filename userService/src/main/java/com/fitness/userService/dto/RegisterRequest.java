package com.fitness.userService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email is required!")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6")
    private String password;

    private String firstName, lastName;
}
