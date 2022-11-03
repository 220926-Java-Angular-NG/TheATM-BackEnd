package com.revashare.theatmbackend.repositories;

import com.revashare.theatmbackend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRepo extends JpaRepository <Transaction, Integer> {
}
