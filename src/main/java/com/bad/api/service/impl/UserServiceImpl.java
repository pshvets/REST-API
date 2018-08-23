package com.bad.api.service.impl;

import com.bad.api.model.User;
import com.bad.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Map<String, User> userList;

    public UserServiceImpl() {
        userList = new HashMap<>();
    }

    @Override
    public User createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);

        userList.put(id, user);
        return user;
    }

    @Override
    public User getUser(String id) {
        return userList.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userList.values());
    }

    @Override
    public void deleteUser(String id) {
        if (userList.containsKey(id)) {
            userList.remove(id);
        }
    }

    @Override
    public User updateUser(String id, User user) {
        if (userList.containsKey(id)) {
            User old = userList.get(id);
            user.setId(old.getId());
            userList.put(id, user);
        }
        return user;
    }
}
