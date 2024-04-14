package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class CreatePostResponse {
    private String title;
    private String content;
    private String author;
}
