package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.Account_t;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository_t extends JpaRepository<Account_t, Long> {
    // 1.사용할 Entity, 2.해당 Entity의 Key Type
}
