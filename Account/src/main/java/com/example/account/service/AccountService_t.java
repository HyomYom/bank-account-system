package com.example.account.service;

import com.example.account.domain.AccountStatus_t;
import com.example.account.domain.Account_t;
import com.example.account.repository.AccountRepository_t;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService_t {
    private final AccountRepository_t accountRepositoryT;

    @Transactional
    public void createAccount_t(){
        Account_t accountT = Account_t.builder()
                .accountNumber_t("3000")
                .accountStatusT(AccountStatus_t.IN_USE)
                .build();

        accountRepositoryT.save(accountT);
    }

    @Transactional
    public Account_t getAccount_t(Long id){
        return accountRepositoryT.findById(id).get();
    }
}
