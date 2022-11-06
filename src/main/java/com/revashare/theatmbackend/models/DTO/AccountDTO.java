package com.revashare.theatmbackend.models.DTO;

import lombok.Data;

@Data
public class AccountDTO {
    Integer id;
    Integer ownerId;
    String type;
    Double totalValue;
}
