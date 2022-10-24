package com.revature.Controllers;

import com.revature.Services.TransService;

public class TransController {
    TransService transService;

    public TransController(){
        this.transService = new TransService();
    }
}
