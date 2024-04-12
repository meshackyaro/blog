package com.myworkspace.blog.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("comments")
public class Comment {
    private String id;
    private String comment;
    @DBRef
    private User commenter;
}
