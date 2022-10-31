package com.revature.Repos;

import com.revature.Models.Account;
import com.revature.Models.Transaction;
import com.revature.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransRepo {

    public Connection conn;

    public TransRepo()
    {
        try
        {
            conn = ConnectionManager.getConnection();
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
    }

    public Transaction create (Transaction trans){

        try
        {
            String sql = "INSERT INTO transactions(trans_id, account_id, from_id, to_id,amount, description, date_of_trans) " +
                    "VALUES(default,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1,trans.getAccountId());
            pstmt.setInt(2,trans.getFrom());
            pstmt.setInt(3,trans.getTo());
            pstmt.setDouble(4,trans.getAmount());
            pstmt.setString(5,trans.getDescription());
            pstmt.setString(6,trans.getDate());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            //;
            while(rs.next())
            {
                trans.setTransId(rs.getInt("trans_id"));
                return trans;
            }


        }
        catch(SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    public List<Transaction> getAll(int accountId) {
        List<Transaction> transactions = new ArrayList<Transaction>();

        try {
            String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY trans_id";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransId(resultSet.getInt("trans_id"));
                transaction.setAccountId(resultSet.getInt("account_id"));
                transaction.setFrom(resultSet.getInt("from_id"));
                transaction.setTo(resultSet.getInt("from_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setDescription(resultSet.getString("description"));
                transaction.setDate(resultSet.getString("date_of_trans"));
                transactions.add(transaction);
            }

            return transactions;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }
}
