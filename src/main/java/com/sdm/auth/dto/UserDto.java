package com.sdm.auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String fullName;
    private LocalDateTime createdAt;
}