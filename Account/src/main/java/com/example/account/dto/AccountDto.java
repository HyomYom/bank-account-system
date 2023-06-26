package com.example.account.dto;

import com.example.account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long userId;
    private String accountNumber;
    private Long balance;
    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    /**
     *
     * 다음과 같이 활용하면
     * 좀더 깔끔하게 형변환이 가능하다.
     * Dto는 주로 Entity를 가지고 만들어지는 경우가 많이 때문에
     * 다음과 같이 변경하는것이 생성자를 통해 만드는것 보다 더 좋은 방법이다.
     */
    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
