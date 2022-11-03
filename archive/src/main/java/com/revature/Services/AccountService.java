package com.revature.Services;

import com.revature.Controllers.AccountController;
import com.revature.Repos.AccountRepo;

public class AccountService {
    AccountRepo accountRepo;

    public AccountService(){
        this.accountRepo = new AccountRepo();
    }
}
