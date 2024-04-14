package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class SignUpResponse {
    private String username;
    private String password;
    private String message;
}
