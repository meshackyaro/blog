package com.myworkspace.blog.exceptions;

public class PostNotFoundException extends BlogException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
