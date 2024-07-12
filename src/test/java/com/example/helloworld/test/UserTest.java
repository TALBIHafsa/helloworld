package com.example.helloworld.test;

import com.example.helloworld.model.dto.UserDto;
import com.example.helloworld.repo.UserRepo;
import com.example.helloworld.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDto userDto = UserDto.builder().id(147).name("hamid").age(55).build();
        when(userRepo.existsById(any())).thenReturn(false);
        String rep = userService.addUser(userDto);
        assertEquals("added", rep);
    }
}
