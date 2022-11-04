package com.revashare.theatmbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String type;

    @ManyToOne
    User owner;

    @ManyToMany
    @JsonIgnore
    List<Transaction> transactions;

}
