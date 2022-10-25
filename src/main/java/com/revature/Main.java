package com.revature;

import com.revature.controllers.UserController;
import com.revature.services.UserService;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Javalin app = Javalin.create(config->{config.enableCorsForAllOrigins();}).start(8080);

        UserController userController = new UserController();
        UserService userService = new UserService();

        app.post("/user", userController.createUser);

    }
}