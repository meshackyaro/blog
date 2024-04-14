package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.User;
import com.myworkspace.blog.data.repositories.PostRepository;
import com.myworkspace.blog.data.repositories.UserRepository;
import com.myworkspace.blog.dtos.requests.*;
import com.myworkspace.blog.dtos.responses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void createPostTest() {
        userRepository.deleteAll();
        postRepository.deleteAll();
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse signUpResponse = userService.signUp(signUpRequest);
        long currentSignUps = userRepository.findAll().size();
        assertEquals(currentSignUps, userService.count());

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("username");
        signInRequest.setPassword("password");
        SignInResponse signInResponse = userService.signIn(signInRequest);
        long currentSignIns = userRepository.findAll().size();
        User user = userService.findByUsername(signInResponse.getUsername());
        assertTrue(user.isLoggedIn());
        assertEquals(currentSignIns, userService.count());

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setContent("content");
        createPostRequest.setAuthor(signInRequest.getUsername());
        CreatePostResponse createPostResponse = postService.createPost(createPostRequest);
        long currentCreatedPosts = userRepository.findAll().size();
        assertEquals(currentCreatedPosts, userService.count());
    }
    @Test
    public void updatePostTest() {
        userRepository.deleteAll();
        postRepository.deleteAll();
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse signUpResponse = userService.signUp(signUpRequest);
        long currentSignUps = userRepository.findAll().size();
        assertEquals(currentSignUps, userService.count());

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("username");
        signInRequest.setPassword("password");
        SignInResponse signInResponse = userService.signIn(signInRequest);
        long currentSignIns = userRepository.findAll().size();
        User user = userService.findByUsername(signInResponse.getUsername());
        assertTrue(user.isLoggedIn());
        assertEquals(currentSignIns, userService.count());

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setContent("content");
        createPostRequest.setAuthor(signInRequest.getUsername());
        CreatePostResponse createPostResponse = postService.createPost(createPostRequest);
        long currentCreatedPosts = userRepository.findAll().size();
        assertEquals(currentCreatedPosts, userService.count());

        UpdatePostRequest updatePostRequest = new UpdatePostRequest();
        updatePostRequest.setAuthor(signInRequest.getUsername());
        updatePostRequest.setTitle(createPostRequest.getTitle());
        updatePostRequest.setNewTitle("new title");
        updatePostRequest.setNewContent("new content");
        UpdatePostResponse updateResponse = postService.updatePost(updatePostRequest);
        long currentUpdatedPosts = userRepository.findAll().size();
        assertEquals("new title", updateResponse.getTitle());
        assertEquals("new content", updateResponse.getContent());
        assertEquals(currentUpdatedPosts, userService.count());
    }
    @Test
    public void deletePostTest() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse signUpResponse = userService.signUp(signUpRequest);
        long currentSignUps = userRepository.findAll().size();
        assertEquals(currentSignUps, userService.count());

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("username");
        signInRequest.setPassword("password");
        SignInResponse signInResponse = userService.signIn(signInRequest);
        long currentSignIns = userRepository.findAll().size();
        User user = userService.findByUsername(signInResponse.getUsername());
        assertTrue(user.isLoggedIn());
        assertEquals(currentSignIns, userService.count());

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setContent("content");
        createPostRequest.setAuthor(signInRequest.getUsername());
        CreatePostResponse createPostResponse = postService.createPost(createPostRequest);
        long currentCreatedPosts = userRepository.findAll().size();
        assertEquals(currentCreatedPosts, userService.count());

        DeletePostRequest deletePostRequest = new DeletePostRequest();
        deletePostRequest.setTitle(createPostRequest.getTitle());
        deletePostRequest.setContent(createPostRequest.getContent());
        deletePostRequest.setAuthor(signInRequest.getUsername());
        postService.deletePost(deletePostRequest);
        long currentDeletedPosts = userRepository.findAll().size();
        assertEquals(currentDeletedPosts, userService.count());
    }

}
