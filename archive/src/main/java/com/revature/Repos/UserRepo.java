package com.revature.Repos;


import com.revature.Models.User;
import com.revature.utils.ConnectionManager;

import java.sql.*;

public class UserRepo {


        public Connection conn;

        public UserRepo()
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
    public int create (User user)
    {

        try
        {
            System.out.println("Schema IS" + conn.getSchema());
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        System.out.println("Inside Repo");
        try
        {
            String sql = "INSERT INTO users(userId, email, username, firstname,lastname,pass_word,phoneNum) " +
                    "VALUES(default,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getEmail());
            pstmt.setString(4,user.getUsername());
            pstmt.setString(2,user.getFirstname());
            pstmt.setString(3,user.getLastname());
            pstmt.setString(5,user.getPass_word());
            pstmt.setString(6,user.getPhoneNum());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            //;
            while(rs.next())
            {
                return rs.getInt("userId");
            }


        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        System.out.println("Makes it to zero");
        return 0;

    }
}
