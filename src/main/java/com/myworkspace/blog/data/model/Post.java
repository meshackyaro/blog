package com.myworkspace.blog.data.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private User author;
    private String title;
    private String content;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
    @DBRef
    private List<View> views = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

}
