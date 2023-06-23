package com.example.account.controller;

import com.example.account.domain.Account_t;
import com.example.account.service.AccountService_t;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController_t {
    private final AccountService_t accountServiceT;
    @GetMapping("/create-account-t")
    public String createAccount_t(){
        accountServiceT.createAccount_t();
        return "success";
    }
    @GetMapping("/account-t/{idd}")
    public Account_t getAccount_t(@PathVariable Long idd){
        return accountServiceT.getAccount_t(idd);
    }
}
