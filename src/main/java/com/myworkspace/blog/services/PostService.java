package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.Post;
import com.myworkspace.blog.dtos.requests.CreatePostRequest;
import com.myworkspace.blog.dtos.requests.DeletePostRequest;
import com.myworkspace.blog.dtos.requests.UpdatePostRequest;
import com.myworkspace.blog.dtos.responses.CreatePostResponse;
import com.myworkspace.blog.dtos.responses.DeletePostResponse;
import com.myworkspace.blog.dtos.responses.UpdatePostResponse;


public interface PostService {
    CreatePostResponse createPost(CreatePostRequest createPostRequest);

    UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest);

    DeletePostResponse deletePost(DeletePostRequest deletePostRequest);

    Post findPostByTitle(String title);
}
