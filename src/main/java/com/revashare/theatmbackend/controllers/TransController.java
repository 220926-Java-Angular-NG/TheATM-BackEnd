package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.models.Transaction;
import com.revashare.theatmbackend.services.TransService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransController {
    private final TransService transService;


    @PostMapping
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

    @GetMapping("/linkedTo/{linkedToId}")
    public List<Transaction> getAllTransactionsLinkedToAccount(@PathVariable Integer linkedToId){
        return transService.findAllTransactionsByLinkedToId(linkedToId);
    }

    @GetMapping("/sumOf/{linkedToId}")
    public Double getSumOfTransactionsOfLinkedToAccount(@PathVariable Integer linkedToId){
        return transService.sumAmountByLinkedToId(linkedToId);
    }
}

