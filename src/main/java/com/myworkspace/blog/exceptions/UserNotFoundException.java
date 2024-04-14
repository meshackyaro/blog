package com.myworkspace.blog.exceptions;

public class UserNotFoundException extends BlogException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
