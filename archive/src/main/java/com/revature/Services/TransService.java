package com.revature.Services;

import com.revature.Models.Transaction;
import com.revature.Repos.TransRepo;

public class TransService {
    TransRepo transRepo;

    public TransService(){
        this.transRepo = new TransRepo();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transRepo.create(transaction);
    }
}
