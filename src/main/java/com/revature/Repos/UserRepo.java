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

            }

        }
    public int create (User user)
    {
        try
        {
            String sql = "INSERT INTO users(userId, email, firstname,lastname, username,password,phoneNum) " +
                    "VALUES(default, ?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getEmail());
            pstmt.setString(2,user.getFirstname());
            pstmt.setString(3,user.getLastname());
            pstmt.setString(4,user.getUsername());
            pstmt.setString(5,user.getPassword());
            pstmt.setString(6,user.getPhoneNum());

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt("userId");

        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }
}
