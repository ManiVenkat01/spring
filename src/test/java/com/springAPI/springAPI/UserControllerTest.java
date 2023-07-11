package com.springAPI.springAPI;

import com.springAPI.springAPI.service.UserService;
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

class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserTest() {
        User user = new User();
        User savedUser = new User();
        when(userService.createUser(user)).thenReturn(savedUser);

        User result = userController.createUser(user);

        assertEquals(savedUser, result);
        verify(userService, times(1)).createUser(user);
    }

    @Test
    void updateUserTest() {
        String id = "testId";
        User user = new User();
        user.setId(id);
        User updatedUser = new User();
        when(userService.updateUser(user)).thenReturn(updatedUser);

        User result = userController.updateUser(id, user);

        assertEquals(updatedUser, result);
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    void deleteUserTest() {
        String id = "testId";

        userController.deleteUser(id);

        verify(userService, times(1)).deleteUser(id);
    }

    @Test
    void getUserByParamTest() {
        String salesPersonName = "John";
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userService.getUserByParam(salesPersonName)).thenReturn(users);

        List<User> result = userController.getUserByParam(salesPersonName);

        assertEquals(users, result);
        verify(userService, times(1)).getUserByParam(salesPersonName);
    }

    @Test
    void getAllUsersTest() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("1", new User());
        when(userService.getAllUsers()).thenReturn(userMap);

        Map<String, User> result = userController.getAllUsers();

        assertEquals(userMap, result);
        verify(userService, times(1)).getAllUsers();
    }
}
