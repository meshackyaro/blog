package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
}
