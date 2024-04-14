package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class SignOutRequest {
    private String username;
    private String password;
}
