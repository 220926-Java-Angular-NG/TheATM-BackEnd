package com.revashare.theatmbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    Account linkedTo;

    @ManyToMany
    //@JsonIgnore
    Account from;

    @ManyToMany
    //@JsonIgnore
    Account to;

    double amount;
    String description;
    String date_of_trans;

}
