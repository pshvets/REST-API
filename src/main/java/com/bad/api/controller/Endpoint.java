package com.bad.api.controller;

import com.bad.api.model.User;
import com.bad.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class Endpoint {

    @Autowired
    UserService userService;

    @PostMapping
    @RequestMapping("/createUser")
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    @RequestMapping("/getUser/{id}")
    public User createUser (@PathVariable(value = "id") String id){
        return userService.getUser(id);
    }

    @GetMapping
    @RequestMapping("/getUsers")
    public List<User> createUser (){
        return userService.getUsers();
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public void deleteUser (@PathVariable String id){
        userService.deleteUser(id);
    }

    @PostMapping
    @RequestMapping("/{id}/update")
    public User updateUser (@PathVariable  String id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
