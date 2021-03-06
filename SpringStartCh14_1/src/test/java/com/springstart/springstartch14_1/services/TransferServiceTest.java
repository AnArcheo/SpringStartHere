package com.springstart.springstartch14_1.services;

import com.springstart.springstartch14_1.model.Account;
import com.springstart.springstartch14_1.repositories.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TransferServiceTest {

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    void transferMoneyHappyFlow() {

        AccountRepository accountRepository = mock(AccountRepository.class);

        TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setAmount(new BigDecimal(1000));

        //controls mock's findById() to return the destination account instance
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        //call the method we want to test
        transferService.transferMoney(sender.getId(), receiver.getId(), new BigDecimal(100));

        //verify that changeAmount() method was called with expected parameters
        verify(accountRepository).changeAmount(1L, new BigDecimal(900));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1100));
    }
}