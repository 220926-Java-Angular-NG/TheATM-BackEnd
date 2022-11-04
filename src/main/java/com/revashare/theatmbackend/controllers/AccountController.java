package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public Account createUser(@RequestBody Account account){
        return accountService.createAccount(account);
    }
}
