package com.revature;


import com.revature.Controllers.UserController;
import io.javalin.Javalin;
import com.revature.Controllers.TransController;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Javalin app = Javalin.create(config->{config.enableCorsForAllOrigins();}).start(8080);

        UserController userController = new UserController();
        TransController transController = new TransController();
        
        app.post("/user", userController.createUser);


        //transactions
        app.post("/transfer",transController.transferMoney);



    }
}