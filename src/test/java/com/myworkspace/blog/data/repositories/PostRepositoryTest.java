package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Test
    public void postRepositoryTest() {
        Post post = new Post();
        postRepository.save(post);
        long currentPost = postRepository.count();
        assertEquals(currentPost, postRepository.count());
    }
}
