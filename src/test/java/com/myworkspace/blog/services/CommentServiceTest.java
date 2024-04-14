package com.myworkspace.blog.services;

import com.mongodb.client.model.BulkWriteOptions;
import com.myworkspace.blog.data.models.User;
import com.myworkspace.blog.data.repositories.CommentRepository;
import com.myworkspace.blog.data.repositories.UserRepository;
import com.myworkspace.blog.dtos.requests.AddCommentRequest;
import com.myworkspace.blog.dtos.requests.CreatePostRequest;
import com.myworkspace.blog.dtos.requests.SignInRequest;
import com.myworkspace.blog.dtos.requests.SignUpRequest;
import com.myworkspace.blog.dtos.responses.AddCommentResponse;
import com.myworkspace.blog.dtos.responses.CreatePostResponse;
import com.myworkspace.blog.dtos.responses.SignInResponse;
import com.myworkspace.blog.dtos.responses.SignUpResponse;
import org.apache.catalina.util.ErrorPageSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;

    @Test
    public void addCommentTest() {

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

        AddCommentRequest addCommentRequest = new AddCommentRequest();
        addCommentRequest.setTitle("title");
        addCommentRequest.setContent("content");
        addCommentRequest.setCommenter("commenter");
        AddCommentResponse addCommentResponse = commentService.comment(addCommentRequest);

    }
}
