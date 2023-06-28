package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.*;
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
public class Account { // DOMAIN = DTO

        @Id
        @GeneratedValue
        private Long id;



        @ManyToOne
        private AccountUser accountUser; //user로 설정시 h2 db의 시스템user와 충동할 수 있다.
        private String accountNumber;
        @Enumerated(EnumType.STRING) // db에 enum 순서 값이 아닌 String으로 바로 저장
        private AccountStatus accountStatus;
        private Long balance;

        private LocalDateTime registeredAt;
        private LocalDateTime unRegisteredAt;

        @CreatedDate // @EntityListeners(AuditingEntityListener.class) 와 동작
        private LocalDateTime createdAt;
        @LastModifiedDate // 자동으로 등록해줌
        private LocalDateTime updatedAt;

        public void useBalance(Long amount){
                if(amount > balance){
                        throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
                }
                balance -= amount;
        }


}
