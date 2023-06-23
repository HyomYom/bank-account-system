package com.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account_t {
    @Id
    @GeneratedValue
    private Long id_t;

    private String accountNumber_t;

    @Enumerated(EnumType.STRING) // db에 enum 값이 아닌 String 값으로 저장;
    private AccountStatus_t accountStatusT;
}
