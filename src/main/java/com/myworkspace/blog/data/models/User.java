package com.myworkspace.blog.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String id;
//    private String firstName;
//    private String lastName;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private LocalDateTime dateCreated;
    @DBRef
    private List<Post> posts = new ArrayList<>();
}
