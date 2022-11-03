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
        return userRepo.create(user);
    }

    public User getUserById(int id)
    {        System.out.println("Inside Service");
        return userRepo.getById(id);
    }
    public User updateUser(User user)
    {
        return userRepo.update(user);
    }

}
