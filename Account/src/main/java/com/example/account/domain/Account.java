package com.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account { // DOMAIN = DTO

        @Id
        @GeneratedValue
        private Long id;


        private String accountNumber;

        @Enumerated(EnumType.STRING) // db에 enum 값이 아닌 String으로 바로 저장
        private AccountStatus accountStatus;

}
