package com.revashare.theatmbackend.models;

import lombok.*;

import javax.persistence.*;

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

}
