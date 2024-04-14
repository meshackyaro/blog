package com.myworkspace.blog.services;

import com.myworkspace.blog.data.models.Post;
import com.myworkspace.blog.data.repositories.PostRepository;
import com.myworkspace.blog.dtos.requests.CreatePostRequest;
import com.myworkspace.blog.dtos.requests.DeletePostRequest;
import com.myworkspace.blog.dtos.requests.UpdatePostRequest;
import com.myworkspace.blog.dtos.responses.CreatePostResponse;
import com.myworkspace.blog.dtos.responses.DeletePostResponse;
import com.myworkspace.blog.dtos.responses.UpdatePostResponse;
import com.myworkspace.blog.exceptions.PostNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        post.setAuthor(createPostRequest.getAuthor());
        postRepository.save(post);

        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setTitle(createPostRequest.getTitle());
        createPostResponse.setContent(createPostRequest.getContent());
        createPostResponse.setAuthor(createPostRequest.getAuthor());
        return createPostResponse;
    }

    @Override
    public UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest) {
        Post foundPost = postRepository.findPostByTitle(updatePostRequest.getTitle());
        if (foundPost == null) throw new PostNotFoundException("Post not found");
        foundPost.setTitle(updatePostRequest.getNewTitle());
        foundPost.setContent(updatePostRequest.getNewContent());
        foundPost.setAuthor(updatePostRequest.getAuthor());

        UpdatePostResponse updatePostResponse = new UpdatePostResponse();
        updatePostResponse.setTitle(updatePostRequest.getNewTitle());
        updatePostResponse.setContent(updatePostRequest.getNewContent());
        updatePostResponse.setAuthor(foundPost.getAuthor());
        return updatePostResponse;
    }

    @Override
    public DeletePostResponse deletePost(DeletePostRequest deletePostRequest) {
        Post foundPost = postRepository.findPostByTitle(deletePostRequest.getTitle());
        if (foundPost == null) throw new PostNotFoundException("Post not found");
        postRepository.delete(foundPost);

        DeletePostResponse deletePostResponse = new DeletePostResponse();
        deletePostResponse.setTitle(deletePostRequest.getTitle());
        deletePostResponse.setContent(deletePostRequest.getContent());
        deletePostResponse.setMessage("Post deleted successfully");
        return deletePostResponse;
    }

    @Override
    public Post findPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }
}
