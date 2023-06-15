package com.example.bank.controller;

import com.example.bank.entity.User;
import com.example.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank")
@Slf4j
public class BankController {

    private final BankService bankService;

    @PostMapping ("open")
    public void openBankAccount(User user) throws RuntimeException{
        bankService.openAccount(user);
    }
}
