package com.myworkspace.blog.data.repositories;

import com.myworkspace.blog.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void userRepositoryTest() {
        User user = new User();
        userRepository.save(user);
        long currentUsers = userRepository.findAll().size();
        assertEquals(currentUsers, userRepository.count());
    }
}
