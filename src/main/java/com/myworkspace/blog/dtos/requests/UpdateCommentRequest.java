package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    private String comment;
    private String author;
    private String newComment;
}
