package com.revature.Controllers;

import com.revature.Models.User;
import com.revature.Services.UserService;
import io.javalin.http.Handler;

public class UserController {
    UserService userService;

    public UserController(){
        this.userService = new UserService();
    }


    public Handler createUser = context->
    {        System.out.println("Inside controller");
      User user = context.bodyAsClass(User.class);
        System.out.println("After body as class");
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
