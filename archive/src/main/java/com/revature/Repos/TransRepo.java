package com.revature.Repos;

import com.revature.Models.Transaction;
import com.revature.utils.ConnectionManager;

import java.sql.*;

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
}
