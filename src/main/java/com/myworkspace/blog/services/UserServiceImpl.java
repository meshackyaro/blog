package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.Post;
import com.myworkspace.blog.data.models.User;
import com.myworkspace.blog.data.repositories.PostRepository;
import com.myworkspace.blog.data.repositories.UserRepository;
import com.myworkspace.blog.dtos.requests.*;
import com.myworkspace.blog.dtos.responses.*;
import com.myworkspace.blog.exceptions.LoginUserException;
import com.myworkspace.blog.exceptions.PostNotFoundException;
import com.myworkspace.blog.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setLoggedIn(true);
        userRepository.save(user);

        SignUpResponse registrationResponse = new SignUpResponse();
        registrationResponse.setUsername(signUpRequest.getUsername());
        registrationResponse.setPassword(signUpRequest.getPassword());
        registrationResponse.setMessage("Successfully signed up");
        return registrationResponse;
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findByUsername(signInRequest.getUsername());
        user.setUsername(signInRequest.getUsername());
        user.setPassword(signInRequest.getPassword());
        user.setLoggedIn(true);
        userRepository.save(user);

        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setUsername(signInRequest.getUsername());
        signInResponse.setMessage("Successfully signed in");
        return signInResponse;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public SignOutResponse signOut(SignOutRequest signOutRequest) {
        User user = findByUsername(signOutRequest.getUsername());
//        user.setUsername(signOutRequest.getUsername());
        user.setLoggedIn(false);
        userRepository.save(user);

        SignOutResponse signOutResponse = new SignOutResponse();
        signOutResponse.setUsername(signOutRequest.getUsername());
        signOutResponse.setMessage("Successfully logged out");
        return signOutResponse;
    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        User foundUser = userRepository.findByUsername(createPostRequest.getAuthor());
        if (foundUser == null) throw new UserNotFoundException("User not found");
        if (!foundUser.isLoggedIn()) throw new LoginUserException("Login to continue");
        Post foundPost = postService.findPostByTitle(createPostRequest.getTitle());
        List<Post> postList = foundUser.getPosts();
        postList.add(foundPost);
        foundUser.setPosts(postList);
        userRepository.save(foundUser);
        return postService.createPost(createPostRequest);
    }

    @Override
    public UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest) {
        User foundUser = userRepository.findByUsername(updatePostRequest.getAuthor());
        if (foundUser == null) throw new UserNotFoundException("User not found");
        if (!foundUser.isLoggedIn()) throw new LoginUserException("Login to continue");
        Post foundPost = postService.findPostByTitle(updatePostRequest.getTitle());
        List<Post> posts = foundUser.getPosts();
        posts.remove(foundPost);


        foundUser.setPosts(posts);


        return postService.updatePost(updatePostRequest);
    }

    @Override
    public DeletePostResponse deletePost(DeletePostRequest deletePostRequest) {
        User foundUser = userRepository.findByUsername(deletePostRequest.getAuthor());
        if (foundUser == null) throw new UserNotFoundException("User not found");
        if (!foundUser.isLoggedIn()) throw new LoginUserException("Login to continue");
        Post foundPost = postService.findPostByTitle(deletePostRequest.getTitle());
        DeletePostResponse deletePostResponse = new DeletePostResponse();
        List<Post> posts = foundUser.getPosts();
        posts.remove(foundPost);
        return deletePostResponse;
    }

}
