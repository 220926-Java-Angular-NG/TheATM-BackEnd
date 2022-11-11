package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.DTO.AccountDTO;
import com.revashare.theatmbackend.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<AccountDTO> getAccountsByOwner(
            @RequestParam(required = true) Integer id,
            @RequestParam(defaultValue = "false") Boolean getSum
    ){
        return accountService.findAllAccountsByOwnerId(id, getSum);
    }

    @GetMapping("/ids")
    public List<Integer> getAllAccountIds(){
        return accountService.findAllAccountNumbers();
    }

}
