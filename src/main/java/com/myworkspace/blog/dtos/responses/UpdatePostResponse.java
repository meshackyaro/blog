package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class UpdatePostResponse {
    private String title;
    private String content;
    private String author;
}
