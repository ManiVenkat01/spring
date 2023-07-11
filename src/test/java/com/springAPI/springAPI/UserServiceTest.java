package com.springAPI.springAPI.service;

import com.springAPI.springAPI.User;
import com.springAPI.springAPI.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserTest() {
        User user = new User();
        User savedUser = new User();
        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.createUser(user);

        assertEquals(savedUser, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void updateUserTest() {
        User user = new User();
        User updatedUser = new User();
        when(userRepository.update(user)).thenReturn(updatedUser);

        User result = userService.updateUser(user);

        assertEquals(updatedUser, result);
        verify(userRepository, times(1)).update(user);
    }

    @Test
    void deleteUserTest() {
        String id = "testId";

        userService.deleteUser(id);

        verify(userRepository, times(1)).delete(id);
    }

    @Test
    void getUserByIdTest() {
        String id = "testId";
        User user = new User();
        when(userRepository.findById(id)).thenReturn(user);

        User result = userService.getUserById(id);

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    void getAllUsersTest() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("1", new User());
        when(userRepository.findAll()).thenReturn(userMap);

        Map<String, User> result = userService.getAllUsers();

        assertEquals(userMap, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserByParamTest() {
        String salesPersonName = "John";
        Map<String, User> userMap = new HashMap<>();
        userMap.put("1", new User());
        when(userRepository.findAll()).thenReturn(userMap);

        List<User> result = userService.getUserByParam(salesPersonName);

        assertEquals(1, result.size());
        verify(userRepository, times(1)).findAll();
    }
}
