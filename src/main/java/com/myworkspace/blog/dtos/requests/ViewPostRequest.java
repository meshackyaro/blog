package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class ViewPostRequest {
    private String title;
    private String content;
    private String author;
    private String viewer;
}
