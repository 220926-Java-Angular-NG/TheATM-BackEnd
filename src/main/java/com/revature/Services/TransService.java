package com.revature.Services;

import com.revature.Models.Transaction;
import com.revature.Repos.TransRepo;

import java.util.List;

public class TransService {
    TransRepo transRepo;

    public TransService() {
        this.transRepo = new TransRepo();
    }

    public TransService(TransRepo transRepo) {
        this.transRepo = transRepo;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transRepo.create(transaction);
    }

    public List<Transaction> getAllTransactions(int accountId) {
        return transRepo.getAll(accountId);
    }
}
