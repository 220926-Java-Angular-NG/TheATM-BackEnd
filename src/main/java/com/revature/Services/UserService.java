package com.revature.Services;
import com.revature.Models.User;
import com.revature.Repos.UserRepo;

public class UserService {
    UserRepo userRepo;

    public  UserService(){
        this.userRepo=new UserRepo();
    }

    public int createUser(User user)
    {
        System.out.println("Inside service");
        return userRepo.create(user);
    }

}
