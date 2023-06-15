package com.example.bank.service;

import com.example.bank.entity.BankAccount;
import com.example.bank.entity.User;
import com.example.bank.exception.SQLException;
import com.example.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;

    public void openAccount(User user) throws RuntimeException{
        BankAccount bankAccount = BankAccount
                .builder()
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .user(user)
                .balance(0)
                .build();

        log.info(bankAccount.toString());

        try {
            bankRepository.save(bankAccount);
        }catch(RuntimeException ex){
            throw new SQLException("Failed to open bank account", ex.getCause());
        }

        log.info("Bank account opened");
    }
}