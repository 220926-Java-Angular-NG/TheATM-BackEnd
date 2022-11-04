package com.revashare.theatmbackend.repositories;

import com.revashare.theatmbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {



    // The user will type in his email in order to get directions to reset password sent to
    // that email
    public User findByEmail(String email);
    public User findByNewPasswordToken(String token);



}
