package com.revature.Controllers;

import com.revature.Services.AccountService;

public class AccountController {
    AccountService accountService;

    public AccountController(){
        this.accountService = new AccountService();
    }
}
