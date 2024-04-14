package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);
}
