package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.models.Account;
import com.revashare.theatmbackend.models.DTO.AccountDTO;
import com.revashare.theatmbackend.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepo accountRepo;
    private final TransService transService;

    public Account createAccount(Account account){
        return accountRepo.save(account);
    }

    public List<AccountDTO> findAllAccountsByOwnerId(Integer id, Boolean getSum) {
        List<Account> accounts = accountRepo.findAllByOwnerId(id);
        List<AccountDTO> accountDTOList = accountToAccountDTO(accounts);
        if (!getSum) return accountDTOList;

        for (AccountDTO accountDTO:accountDTOList){
            accountDTO.setTotalValue(transService.sumAmountByLinkedToId(accountDTO.getId()));
        }
        return  accountDTOList;
    }

    private List<AccountDTO> accountToAccountDTO (List <Account> accounts){
        List<AccountDTO> accountDTOList = new ArrayList<>();
        for (Account account:accounts){
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(account.getId());
            accountDTO.setOwnerId(account.getOwner().getId());
            accountDTO.setType(account.getType());
            accountDTOList.add(accountDTO);
        }
        return  accountDTOList;
    }
}
