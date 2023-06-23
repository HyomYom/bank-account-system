package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository; // final 선언하면 무조건 생서자에 담김


    @Transactional
    public void createAccount(){
        Account account = Account.builder()
                .accountNumber("4000")
                .accountStatus(AccountStatus.IN_USE)
                .build();

        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id){
        if(id < 0){
            throw new RuntimeException("Minus");
        }

        return accountRepository.findById(id).get();
    }
}
