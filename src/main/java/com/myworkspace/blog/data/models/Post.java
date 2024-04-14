package com.myworkspace.blog.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("posts")
public class Post {
    private String id;
    private String author;
    private String title;
    private String content;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
    @DBRef
    private List<View> views = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

}
