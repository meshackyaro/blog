package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.User;
import com.myworkspace.blog.dtos.requests.*;
import com.myworkspace.blog.dtos.responses.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    SignUpResponse signUp(SignUpRequest signUpRequest);

    long count();

    SignInResponse signIn(SignInRequest signInRequest);

    User findByUsername(String username);

    SignOutResponse signOut(SignOutRequest signOutRequest);

    CreatePostResponse createPost(CreatePostRequest createPostRequest);

    UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest);

    DeletePostResponse deletePost(DeletePostRequest deletePostRequest);
}
