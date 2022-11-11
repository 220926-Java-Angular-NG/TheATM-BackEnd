package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
