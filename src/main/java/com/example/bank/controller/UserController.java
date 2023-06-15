package com.example.bank.controller;

import com.example.bank.model.UserModel;
import com.example.bank.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userSerivce;

    @PostMapping("register")
    ResponseEntity<String> registerUsers(@Valid @RequestBody UserModel userModel) {
        try {
            return userSerivce.registerUser(userModel);
        } catch (RuntimeException ex) {
            log.error("Following exception found: " + ex.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}