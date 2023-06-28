package com.example.account.domain;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne
    private Account account;
    private  Long amount;
    private Long balanceSnapshot; // 현재 거래 후 금액

    private String transactionId;
    private LocalDateTime transactedAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

}
