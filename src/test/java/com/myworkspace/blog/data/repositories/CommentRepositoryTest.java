package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.Comment;
import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void commentRepositoryTest() {
        Comment comment = new Comment();
        commentRepository.save(comment);
        long currentComments = commentRepository.findAll().size();
        assertEquals(currentComments, commentRepository.count());
    }
}
