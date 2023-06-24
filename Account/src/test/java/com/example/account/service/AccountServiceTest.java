package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.dto.AccountDto;
import com.example.account.repository.AccountUserRepository;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock // 의존성 객체를 생성하여 주입해주는 과정
    private AccountRepository accountRepository;
    @Mock
    private AccountUserRepository accountUserRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccountSuccess() {
        //given
        AccountUser user = AccountUser.builder()
                .id(12L)
                .name("Pobi").build();

        given(accountUserRepository.findById(anyLong()))
                .willReturn(Optional.of(user));

        given(accountRepository.findFirstByOrderByIdDesc())
                .willReturn(Optional.of(Account.builder()
                        .accountNumber("1000000012")
                        .build()));

        given(accountRepository.save(any()))
                .willReturn(Account.builder()
                        .accountUser(user)
                        .accountNumber("1000000015")
                        .build());

        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
        //when
        AccountDto accountDto = accountService.createAccount(1L, 1000L);
        //then
        verify(accountRepository, times(1)).save(captor.capture());
        assertEquals(12L, accountDto.getUserId());
        assertEquals("1000000013", captor.getValue().getAccountNumber());

    }


//    @Test
//    @DisplayName("계좌 조회 성공")
//        void testXXX() {
//            //given
//            given(accountRepository.findById(anyLong()))
//                    .willReturn(Optional.of(Account.builder()
//                            .accountStatus(AccountStatus.IN_USE)
//                            .accountNumber("4000").build()));
//
//            // 의존하고 있는 Mock에 전달된 데이터가 내가 의도한 데이터가 맞는지 검증
//        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
//
//
//            //when
//            Account account = accountService.getAccount(4555L);
//
//            //then
//        verify(accountRepository, times(1)).findById(captor.capture()); // 다음 메소드를 호출하는지 확인
//        verify(accountRepository, times(0)).save(any()); // 저장은 하 면 안된다.
//
//        assertEquals(4555L, captor.getValue());
//        assertNotEquals(45551L, captor.getValue());
//        assertEquals("4000", account.getAccountNumber());
//        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
//        }
//
//    @Test
//    @DisplayName("계좌 조회 실패 - 음수로 조회")
//    void testFailedToSearchAccount() {
//        //given
//
//        //when
//        RuntimeException runtimeException = assertThrows(RuntimeException.class,
//                () -> accountService.getAccount(-10L));
//
//        //then
//        assertEquals("Minus", runtimeException.getMessage());
//    }
//
//    @Test
//    @DisplayName("Test 이름 변경")
//        void testGetAccount() {
//
//        Account account = accountService.getAccount(1L);
//            //given
//            //when
//            //then
//
//        assertEquals("4000", account.getAccountNumber());
//        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
//        }
//
//        @Test
//            void testGetAccount2() {
//                //given
//            Account account = accountService.getAccount(2L);
//                //when
//                //then
//            assertEquals("4000", account.getAccountNumber());
//            assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
//            }

}