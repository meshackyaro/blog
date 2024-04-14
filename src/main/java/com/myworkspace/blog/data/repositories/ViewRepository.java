package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View, String> {
}
