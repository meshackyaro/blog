package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class DeleteCommentRequest {
    private String comment;
    private String commenter;
}
