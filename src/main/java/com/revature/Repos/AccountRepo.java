package com.revature.Repos;

import com.revature.Models.Account;
import com.revature.Models.Transaction;
import com.revature.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo {

    public Connection conn;

    public AccountRepo() {
        try {
            conn = ConnectionManager.getConnection();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public int create(Account account) {
        try {
            String sql = "INSERT INTO accounts(account_id, account_type, account_owner, amount) VALUES (default,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, account.getAccountType());
            preparedStatement.setInt(2, account.getOwnerId());
            preparedStatement.setDouble(3,account.getAmount());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while(resultSet.next()) {
                return resultSet.getInt("account_id");
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return 0;
    }

    // Gets all accounts owned by a specified user
    public List<Account> getAll(int userId) {
        List<Account> accounts = new ArrayList<Account>();

        try {
            String sql = "SELECT * FROM accounts WHERE account_owner = ? ORDER BY account_id";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("account_id"));
                account.setAccountType(resultSet.getString("account_type"));
                account.setOwnerId(resultSet.getInt("account_owner"));
                account.setAmount(resultSet.getDouble("amount"));
                accounts.add(account);
            }

            return accounts;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    public Account getById(int id) {
        try {
            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = new Account();

            while (resultSet.next()) {
                account.setAccountId(resultSet.getInt("account_id"));
                account.setAccountType(resultSet.getString("account_type"));
                account.setOwnerId(resultSet.getInt("account_owner"));
                account.setAmount(resultSet.getDouble("amount"));
            }

            return account;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    public Account update(Account account) {
        try {
            String sql = "UPDATE accounts SET amount = ? WHERE account_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, account.getAmount());
            preparedStatement.setInt(2, account.getAccountId());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                account.setAmount(resultSet.getDouble("amount"));
            }

            return account;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    public Account trackIncome(Account account, Transaction income) {
        account.setAmount(account.getAmount() + income.getAmount());

        return update(account);
    }

    public Account trackExpenses(Account account, Transaction expenses) {
        account.setAmount(account.getAmount() - expenses.getAmount());

        return update(account);
    }

}
