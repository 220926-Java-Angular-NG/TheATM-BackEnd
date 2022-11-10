package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.ResourceNotFoundException;
import com.revashare.theatmbackend.UserNotFoundException;
import com.revashare.theatmbackend.models.DTO.AuthRequest;
import com.revashare.theatmbackend.models.DTO.AuthResponse;
import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo userRepo;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

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
        user.setPass_word(hiddenPassword);
        user.setResetPasswordToken(null);
        userRepo.save(user);
    }

    public AuthResponse loginUser(AuthRequest authRequest) {
        // try to authenticate the user
        // short circuit the execution with an exception
        // TODO: confirm the password being checked against the database is encoded first
        User user = findUserByEmail(authRequest.getEmail());
        if (user.getPass_word().equals(authRequest.getPassword())) {
            return generateAuthenticationResponse(user);
        } else {
            System.out.println("Password given does not match: " + authRequest + ":" + user);
            return new AuthResponse(null, user);
        }
    }
    // what we need to do now is get the user loaded, then generate the token/response

    private AuthResponse generateAuthenticationResponse(User user){
        return new AuthResponse(authService.generateToken(user), user);
    }

    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
                //.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        return findUserByEmail(email);
    }

}