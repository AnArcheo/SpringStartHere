package com.springstart.springstartch14_1.services;

import com.springstart.springstartch14_1.exceptions.AccountNotFoundException;
import com.springstart.springstartch14_1.model.Account;
import com.springstart.springstartch14_1.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow(){
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

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow(){
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L))
                .willReturn(Optional.of(sender));

        //to return empty Optional when findById() is called
        given(accountRepository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class,
                ()->transferService.transferMoney(1L,2L,new BigDecimal(100L)));

        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}
