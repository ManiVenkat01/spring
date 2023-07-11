package com.springAPI.springAPI.repository;


import com.springAPI.springAPI.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return userMap.get(id);
    }

    @Override
    public Map<String, User> findAll() {
        return userMap;
    }

    @Override
    public User update(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(String id) {
        userMap.remove(id);
    }
}