package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.UserNotFoundException;
import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user) {return userRepo.save(user);
    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepo.save(user);
        } else {
            throw new UserNotFoundException(email + " is not associated with any user");
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepo.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String password2) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hiddenPassword = passwordEncoder.encode(password2);
        user.setPassword(hiddenPassword);

        user.setResetPasswordToken(null);
        userRepo.save(user);
    }
}
