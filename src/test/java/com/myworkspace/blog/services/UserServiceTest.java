package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.User;
import com.myworkspace.blog.data.repositories.UserRepository;
import com.myworkspace.blog.dtos.requests.SignInRequest;
import com.myworkspace.blog.dtos.requests.SignOutRequest;
import com.myworkspace.blog.dtos.requests.SignUpRequest;
import com.myworkspace.blog.dtos.responses.SignInResponse;
import com.myworkspace.blog.dtos.responses.SignOutResponse;
import com.myworkspace.blog.dtos.responses.SignUpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void newUserRegistrationTest() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse response = userService.signUp(signUpRequest);
        long currentUsers = userRepository.findAll().size();
        assertEquals(currentUsers, userService.count());
    }
    @Test
    public void registeredUserSignIn_signInTest() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse response = userService.signUp(signUpRequest);
        long currentUsers = userRepository.findAll().size();
        assertEquals(currentUsers, userService.count());

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername(signUpRequest.getUsername());
        signInRequest.setPassword(signUpRequest.getPassword());
        long currentlyLoggedIn = userRepository.findAll().size();
        SignInResponse response1 = userService.signIn(signInRequest);
        User user = userService.findByUsername(signInRequest.getUsername());
        assertTrue(user.isLoggedIn());
        assertEquals(currentlyLoggedIn, userService.count());
    }
    @Test
    public void registeredUserSignOut_signOutTest() {
        userRepository.deleteAll();
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        SignUpResponse response = userService.signUp(signUpRequest);
        long currentUsers = userRepository.findAll().size();
        assertEquals(currentUsers, userService.count());

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername(signUpRequest.getUsername());
        signInRequest.setPassword(signUpRequest.getPassword());
        long currentlyLoggedIn = userRepository.findAll().size();
        SignInResponse response1 = userService.signIn(signInRequest);
        User user = userService.findByUsername(signInRequest.getUsername());
        assertTrue(user.isLoggedIn());
        assertEquals(currentlyLoggedIn, userService.count());

        SignOutRequest signOutRequest = new SignOutRequest();
        signOutRequest.setUsername(signInRequest.getUsername());
        SignOutResponse response2 = userService.signOut(signOutRequest);
        user = userService.findByUsername(signOutRequest.getUsername());
        assertFalse(user.isLoggedIn());
        assertEquals(currentlyLoggedIn, userService.count());
    }
}
