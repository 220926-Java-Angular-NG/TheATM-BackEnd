package com.revature.Services;

import com.revature.Repos.UserRepo;

public class UserService {
    UserRepo userRepo;

    public  UserService(){
        this.userRepo=new UserRepo();
    }

}
