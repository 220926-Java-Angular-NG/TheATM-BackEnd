package com.revature.Models;

public class Transaction {
    int transId;
    int accountId;
    String from;
    String to;
    double amount;
    String description;
    String date;

    public Transaction() {
    }

    public Transaction(int transId, String from, String to, double amount, int accountId,
                       String description, String date) {
        this.transId = transId;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", accountId=" + accountId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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
