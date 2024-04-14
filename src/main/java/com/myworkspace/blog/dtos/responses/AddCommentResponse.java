package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class AddCommentResponse {
    private String comment;
    private String title;
    private String author;
}
