package com.springAPI.springAPI;

import com.springAPI.springAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/submission")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable String id) {
//        return userService.getUserById(id);
//    }
@GetMapping("/id")
    public List<User> getUserByParam(@RequestParam String salesPersonName) {
        return userService.getUserByParam(salesPersonName);
    }

    @GetMapping
    public Map<String, User> getAllUsers() {
        return userService.getAllUsers();
    }
}