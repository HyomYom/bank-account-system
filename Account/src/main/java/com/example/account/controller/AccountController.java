package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.dto.CreateAccount;
import com.example.account.repository.AccountRepository;
import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;
    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request
            ){
        accountService.createAccount();
        return "succcess";
    }

    @GetMapping("/get-lock")
    public String getLock(){
        return redisTestService.getLock();
    }




    @GetMapping("/account/{id}")
    public Account getAccount(
            @PathVariable  Long id){
        return accountService.getAccount(id);
    }
}
