package com.myworkspace.blog.dtos.requests;

import lombok.Data;

@Data
public class UpdatePostRequest {
    private String author;
    private String title;
    private String newTitle;
    private String newContent;
}
