package com.sdm.auth.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private String fullName;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}