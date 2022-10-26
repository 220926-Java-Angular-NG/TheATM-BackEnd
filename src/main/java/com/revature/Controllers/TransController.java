package com.revature.Controllers;

import com.revature.Models.Transaction;
import com.revature.Services.TransService;
import io.javalin.http.Handler;

public class TransController {
    TransService transService;
    public TransController(){
        this.transService = new TransService();
    }

    //given a transaction with ownerId, to (account number), from (account number), amount, description, and date?
    //make 2 new transactions - one to lower the current amount in the starting account, one to add to the sending account
    public Handler transferMoney = context ->{
        Transaction trans = context.bodyAsClass(Transaction.class);
        if (trans==null){
            context.result("Transaction not built properly").status(400);
        } else {
            trans.setDate();
            Transaction subtract = new Transaction(trans.getFrom(), trans.getTo(),trans.getAmount()*-1,
                    trans.getAccountId(), trans.getDescription(), trans.getDate());
            Transaction add = new Transaction(trans.getTo(), trans.getFrom(),trans.getAmount(),
                    trans.getAccountId(), trans.getDescription(), trans.getDate());

            //transService.createTransaction(subtract);
            //transService.createTransaction(add);Commented out to be able to test - Alvin
        }
    };
}
