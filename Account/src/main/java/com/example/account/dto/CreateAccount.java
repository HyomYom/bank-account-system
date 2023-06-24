package com.example.account.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CreateAccount {
    public static class Request {
        @Getter
        @Setter
        private Long userId;
        private Long initialBalance;


    }
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Response {
            private Long userId;
            private String accountNumber;
            private LocalDateTime registeredAt;
        }

}
