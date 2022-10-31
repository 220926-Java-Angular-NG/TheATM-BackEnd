package com.revature.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    int transId;
    int accountId;
    int from;
    int to;
    double amount;
    String description;
    String date;

    public Transaction() {
    }

    public Transaction(int transId, int from, int to, double amount, int accountId,
                       String description, String date) {
        this.transId = transId;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.accountId = accountId;
        this.description = description;
        this.date = date;
    }

    public Transaction(int from, int to, double amount, int accountId,
                       String description, String date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.accountId = accountId;
        this.description = description;
        this.date = date;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate(){
        if (this.date==null) {
            Date newDate = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(newDate);
            setDate(strDate);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", accountId=" + accountId +
                ", from=    '" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
