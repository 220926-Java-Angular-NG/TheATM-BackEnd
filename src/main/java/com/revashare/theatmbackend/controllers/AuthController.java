package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.DTO.AccountDTO;
import com.revashare.theatmbackend.models.DTO.AuthRequest;
import com.revashare.theatmbackend.models.DTO.AuthResponse;
import com.revashare.theatmbackend.models.Transaction;
import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.services.AccountService;
import com.revashare.theatmbackend.services.TransService;
import com.revashare.theatmbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final TransService transService;
    private final AccountService accountService;

//    @PostMapping("/register")
//    public RegistrationResponse register(@RequestBody RegistrationRequest registrationRequest){
//        return userService.registerUser(registrationRequest);
//    }
    @PostMapping("/register")
    public User createUser(@RequestBody User user){

        System.out.println(user);

        return userService.createUser(user);

}


    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        System.out.println(authRequest);
        return userService.loginUser(authRequest);
    }
    @PostMapping("/transaction")
    public List<Transaction> subtractFrom_FromAndAddTo_To(@RequestBody Transaction trans){
        Transaction subtract = new Transaction(trans.getId(),trans.getLinkedTo(),trans.getFrom(), trans.getTo(),
                trans.getAmount()*-1, trans.getDescription(),trans.getDate_of_trans());
        Transaction add = new Transaction(trans.getId(), trans.getTo(), trans.getFrom(), trans.getTo(),
                trans.getAmount(), trans.getDescription(), trans.getDate_of_trans());


        subtract = transService.createTransaction(subtract);
        add = transService.createTransaction(add);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(subtract);
        transactions.add(add);

        return transactions;
    }

    @GetMapping("/shops")
    public List<AccountDTO> getAllShops(){
        return accountService.findAllAccountsByOwnerId(1,false);
    }
}