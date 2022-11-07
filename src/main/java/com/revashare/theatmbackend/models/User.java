package com.revashare.theatmbackend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "email")
    String email;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "pass_word")
    String pass_word;

    @Column(name = "phoneNum")
    String phoneNum;

    @Column(name="reset_password_token")
    String resetPasswordToken;

}
