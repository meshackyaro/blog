package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class AddCommentRequest {
    private String title;
    private String content;
    private String commenter;
}
