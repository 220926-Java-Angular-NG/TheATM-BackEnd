package com.revashare.theatmbackend.repositories;

import com.revashare.theatmbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {



    // The user will type in his email in order to get directions to reset password sent to
    // that email
    // @Query annotation defines SQL to execute, in this case need to find email

    //@Query("SELECT u from User u WHERE u.email = ?1")
    //public User findByEmail(String email);
    Optional<User> findByEmail(String email);
    public User findByResetPasswordToken(String token);



}
