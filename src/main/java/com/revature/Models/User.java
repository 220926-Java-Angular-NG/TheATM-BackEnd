package com.revature.Models;

import java.util.List;

public class User {
    int userId;
    String email;
    String username;
    String firstname;
    String lastname;
    String pass_word;
    String phoneNum;


    public User()
    {

    }

    public User(String email, String username, String firstname, String lastname, String pass_word, String phoneNum) {
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pass_word = pass_word;
        this.phoneNum = phoneNum;
    }

    public User(int userId, String email, String username, String firstname, String lastname, String pass_word, String phoneNum) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pass_word = pass_word;
        this.phoneNum = phoneNum;
    }

    public int getUserId() {
        return userId;
    }
    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPass_word() {
        return pass_word;
    }

    public String getPhoneNum() {
        return phoneNum;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
        }


}
