package com.revature.services;

import com.revature.Models.User;
import com.revature.Repos.UserRepo;

public class UserService {
    UserRepo userRepo;

    public  UserService(){
        this.userRepo=new UserRepo();
    }

    public int createUser(User user)
    {
        return userRepo.create(user);
    }

}
