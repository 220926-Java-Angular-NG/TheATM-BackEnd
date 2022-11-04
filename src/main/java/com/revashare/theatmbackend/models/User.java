package com.revashare.theatmbackend.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String email;
    String firstname;
    String lastname;
    String pass_word;
    String phoneNum;



    @Column(name="reset_password_token")
    String newPasswordToken;

}
