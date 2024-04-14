package com.myworkspace.blog.dtos.responses;

import lombok.Data;

@Data
public class DeleteCommentResponse {
    private String comment;
    private String commenter;
}
