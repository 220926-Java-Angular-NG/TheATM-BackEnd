package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepo accountRepo;

    public Account createAccount(Account account){
        return accountRepo.save(account);
    }
}
