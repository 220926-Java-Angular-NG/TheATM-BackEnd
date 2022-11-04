package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }
}
