package com.revashare.theatmbackend.repositories;

import com.revashare.theatmbackend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface TransRepo extends JpaRepository <Transaction, Integer> {

    List<Transaction> findAllByLinkedTo_Id(Integer linkedToId);

}

