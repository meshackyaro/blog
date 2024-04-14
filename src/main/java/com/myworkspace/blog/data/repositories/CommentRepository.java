package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
