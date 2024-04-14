package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class AddCommentResponse {
    private String title;
    private String content;
    private String commenter;
    private String message;
}
