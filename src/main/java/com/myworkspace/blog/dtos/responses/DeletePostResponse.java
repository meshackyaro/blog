package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class DeletePostResponse {
    private String author;
    private String title;
    private String content;
    private String message;
}
