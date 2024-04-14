package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
    private String author;
}
