package com.springAPI.springAPI.service;

import com.springAPI.springAPI.User;
import com.springAPI.springAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }

    public User getUserById(String id) {
        return userRepository.findById(id);
    }

    public Map<String, User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByParam(String salesPersonName) {

        Map<String, User> users = userRepository.findAll();

        if (salesPersonName != null) {
            users = users.entrySet().stream()
                    .filter(entry -> entry.getValue().getSalesPersonName().equals(salesPersonName))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        return users.values().stream().collect(Collectors.toList());

//        Map<String, User> users = userRepository.findAll();
////        if (salesPersonName != null) {
//           return users;


//        }


//        Map<String, User> users = userRepository.findAll().values().stream();
//
//        if (salesPersonName != null) {
//            users = users.filter(user -> user.getSalesPersonName().equals(salesPersonName));
//        }


    }
}