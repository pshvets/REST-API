package com.bad.api.service;

import com.bad.api.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUser(String id);

    List<User> getUsers();

    void deleteUser(String id);

    User updateUser(String id, User user);
}
