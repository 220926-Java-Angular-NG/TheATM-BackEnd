package com.revashare.theatmbackend.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "users")
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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        //later we want this to be a list of granted authorities
        return null;
    }
}
