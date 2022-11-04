package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user) {return userRepo.save(user);
    }

    public void updateNewPasswordToken(String token, String email) throws UserNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.setNewPasswordToken(token);
            userRepo.save(user);
        } else {
            throw new UserNotFoundException(email + " is not associated with any user");
        }
    }

    public User getByNewPasswordToken(String token) {
        return userRepo.findByNewPasswordToken(token);
    }

    public void updatePassword(User user, String password2) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hiddenPassword = passwordEncoder.encode(password2);
        user.setPassword(hiddenPassword);

        user.setNewPasswordToken(null);
        userRepo.save(user);
    }
}
