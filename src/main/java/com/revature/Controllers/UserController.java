package com.revature.controllers;

import com.revature.Models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

public class UserController {
    UserService userService;

    public UserController(){
        this.userService = new UserService();
    }


    public Handler createUser = context->
    {
      User user = context.bodyAsClass(User.class);
      int id = userService.createUser(user);
      if(id>0)
      {
          user.setUserId(id);
          context.json(user).status(200);
      }
      else
          context.result("User not created").status(400);
    };
}
