package com.revashare.theatmbackend.config;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.services.AccountService;
import com.revashare.theatmbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OnApplicationStartUp {

    private final UserService userService;
    private final AccountService accountService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (accountService.findAllAccountsByOwnerId(1, false)==null) {
            preloadData();
        }
    }

    private void preloadData() {
        User bank = new User(1, "bank@bank.com", "bank", "bank",
                "supersecret", "1234567890");
        bank = userService.createUser(bank);
        List<String> stores = Arrays.asList("Job", "FlyNSwaggies", "MTGAllDay","WeScream4IceCream");
        for (int i=0;i< stores.size()-1;i++){
            Account account = new Account(i, stores.get(i), bank, null);
            accountService.createAccount(account);
        }


    }
}