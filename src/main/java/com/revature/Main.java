package com.revature;

import com.revature.Controllers.TransController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //  Javalin app = Javalin.create(config ->{
        //                config.enableCorsForAllOrigins();
        //            }).start(8080);
        TransController transController = new TransController();


        //transactions
        //app.post("/transfer",transController.transferMoney);



    }
}