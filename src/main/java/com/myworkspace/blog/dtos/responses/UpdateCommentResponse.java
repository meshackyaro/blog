package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class UpdateCommentResponse {
    private String comment;
    private String author;
    private String message;
}
