package com.revashare.theatmbackend.repositories;

import com.revashare.theatmbackend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository <Account, Integer>{
}
