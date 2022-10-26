package com.revature.Controllers;

import com.revature.Models.Transaction;
import com.revature.Services.TransService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class TransController {
    TransService transService;
    public TransController(){
        this.transService = new TransService();
    }

    //given a transaction with ownerId, to (account number), from (account number), amount, description, and date?
    //make 2 new transactions - one to lower the current amount in the starting account, one to add to the sending account
    //return a list of transactions created
    public Handler transferMoney = context ->{
        Transaction trans = context.bodyAsClass(Transaction.class);
        if (trans==null){
            context.result("Transaction not built properly").status(400);
        } else {
            trans.setDate();
            Transaction subtract = new Transaction(trans.getFrom(), trans.getTo(),trans.getAmount()*-1,
                    trans.getAccountId(), trans.getDescription(), trans.getDate());
            Transaction add = new Transaction(trans.getFrom(), trans.getTo(),trans.getAmount(),
                    trans.getTo(), trans.getDescription(), trans.getDate());

            List<Transaction> transactions = new ArrayList();
            Transaction newTrans = transService.createTransaction(subtract);
            Transaction newTrans1 = transService.createTransaction(add);
            if (newTrans.getTransId()>0 && newTrans1.getTransId()>0 ) {
                transactions.add(newTrans);
                transactions.add(newTrans1);
                context.json(transactions);
            }
        }
    };
}
