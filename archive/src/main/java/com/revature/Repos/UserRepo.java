package com.revature.Repos;


import com.revature.Models.User;
import com.revature.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

            while(rs.next())
            {
                return rs.getInt("userId");
            }


        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;

    }

    public User getById(int id)
    {
        try
        {
            String sql = "SELECT * FROM users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            User user = new User();
            while(rs.next())
            {
                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPass_word(rs.getString("pass_word"));
                user.setPhoneNum(rs.getString("phoneNum"));
            }
            return user;
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }
    public User update(User user)
    {
        try
        {
            String sql = "UPDATE users SET email = ?, " +
                    "username = ?, firstname = ?, lastname = ?, pass_word = ?," +
                    "phoneNum = ? WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getEmail());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getFirstname());
            pstmt.setString(4,user.getLastname());
            pstmt.setString(5,user.getPass_word());
            pstmt.setString(6,user.getPhoneNum());
            pstmt.setInt(7,user.getUserId());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            while(rs.next())
            {
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPass_word(rs.getString("pass_word"));
                user.setPhoneNum(rs.getString("phoneNum"));
            }

            return user;

        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return null;

    }
}
