package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.View;
import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ViewRepositoryTest {
    @Autowired
    private ViewRepository viewRepository;

    @Test
    public void viewRepositoryTest() {
        View view = new View();
        viewRepository.save(view);
        long currentView = viewRepository.findAll().size();
        assertEquals(currentView, viewRepository.count());

    }
}
