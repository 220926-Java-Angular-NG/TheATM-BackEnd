package com.revature.Controllers;

import com.revature.Services.UserService;

public class UserController {
    UserService userService;

    public UserController(){
        this.userService = new UserService();
    }
}
