package com.revature.Services;

import com.revature.Repos.TransRepo;

public class TransService {
    TransRepo transRepo;

    public TransService(){
        this.transRepo = new TransRepo();
    }
}
