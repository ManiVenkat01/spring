package com.springAPI.springAPI.repository;

import com.springAPI.springAPI.User;

import java.util.Map;

public interface UserRepository {
    User save(User user);

    User findById(String id);

    Map<String, User> findAll();

    User update(User user);

    void delete(String id);
}