package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.Comment;
import com.myworkspace.blog.dtos.requests.AddCommentRequest;
import com.myworkspace.blog.dtos.responses.AddCommentResponse;

public class CommentServiceImpl implements CommentService {

    @Override
    public AddCommentResponse comment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        comment.setTitle(addCommentRequest.getTitle());
        comment.setContent(addCommentRequest.getContent());
        comment.setCommenter(addCommentRequest.getCommenter());

        AddCommentResponse addCommentResponse = new AddCommentResponse();
        addCommentResponse.setTitle(addCommentRequest.getTitle());
        addCommentResponse.setContent(addCommentResponse.getContent());
        addCommentResponse.setCommenter(addCommentRequest.getCommenter());
        addCommentResponse.setMessage("Comment added successfully");
        return addCommentResponse;
    }
}
