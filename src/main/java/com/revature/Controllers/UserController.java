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

    public Handler getUserById = context ->
    {        System.out.println("Inside controller");
        String param = context.pathParam("id");
        User user;//Note, remove context body as class?
               System.out.println("Param " + param);
        try
        {
            int id = Integer.parseInt(param);
            user = userService.getUserById(id);
            System.out.println("Id " + id);
            if(user != null)
                context.json(user).status(200);
            else
                context.result("User not found").status(400);
        }
        catch(NumberFormatException numberFormatException)
        {
            System.out.println(numberFormatException.getMessage());
        }
    };

    public Handler updateUser = context ->
    {
        User user = context.bodyAsClass(User.class);
        user = userService.updateUser(user);
        if(user != null)
            context.json(user).status(200);
        else
            context.result("Can't update user").status(400);
    };
}
