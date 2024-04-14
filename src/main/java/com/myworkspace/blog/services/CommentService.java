package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.Comment;
import com.myworkspace.blog.dtos.requests.AddCommentRequest;
import com.myworkspace.blog.dtos.responses.AddCommentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    AddCommentResponse comment(AddCommentRequest addCommentRequest);
}
