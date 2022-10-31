package com.revature.Services;

import com.revature.Controllers.AccountController;
import com.revature.Models.Account;
import com.revature.Models.Transaction;
import com.revature.Repos.AccountRepo;

import java.util.List;

public class AccountService {
    AccountRepo accountRepo;

    public AccountService() {
        this.accountRepo = new AccountRepo();
    }

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public int createAccount(Account account) {
        return accountRepo.create(account);
    }

    public List<Account> getAllAccounts(int userId) {
        return accountRepo.getAll(userId);
    }

    public Account getAccountById(int id) {
        return accountRepo.getById(id);
    }

    public Account updateAccount(Account account) {
        return accountRepo.update(account);
    }

    public Account trackIncome(Account account, Transaction income) {
        return accountRepo.trackIncome(account, income);
    }

    public Account trackExpenses(Account account, Transaction expenses) {
        return accountRepo.trackExpenses(account, expenses);
    }
}
