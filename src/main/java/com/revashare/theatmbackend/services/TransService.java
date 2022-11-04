package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.Transaction;
import com.revashare.theatmbackend.repositories.TransRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransService {
    private final TransRepo transRepo;

    public Transaction createTransaction(Transaction transaction){
        return transRepo.save(transaction);
    }

    public List<Transaction> findAllTransactionsByLinkedToId(Integer linkedToId) {
        return transRepo.findAllByLinkedTo_Id(linkedToId);
    }

    public Double sumAmountByLinkedToId(Integer linkedToId){
        List<Transaction> transactions =  transRepo.findAllByLinkedTo_Id(linkedToId);
        Double sum = Double.valueOf(0);
        for (Transaction transaction:transactions){
            sum+=Double.valueOf(transaction.getAmount());
        }
        return sum;
    }
}
