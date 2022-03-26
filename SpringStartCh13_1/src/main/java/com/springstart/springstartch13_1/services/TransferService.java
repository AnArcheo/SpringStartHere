package com.springstart.springstartch13_1.services;

import com.springstart.springstartch13_1.model.Account;
import com.springstart.springstartch13_1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //method to transfer money
    //transactional to keep data consistency

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        //get account details by id's
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);
        //calculate new amounts after sending transfer
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        //set new amount for the sender account
        accountRepository.changeAmount(idSender, senderNewAmount);
        //set new amount for the receiver account
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    //service method that returns all existing accounts
    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }
}
