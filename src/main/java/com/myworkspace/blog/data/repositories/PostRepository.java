package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostByTitle(String title);
}
