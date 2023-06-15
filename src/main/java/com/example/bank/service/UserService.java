package com.example.bank.service;

import com.example.bank.controller.BankController;
import com.example.bank.entity.User;
import com.example.bank.exception.SQLException;
import com.example.bank.model.UserModel;
import com.example.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BankController bankController;
    private final PasswordEncoder passEncoder;

    public ResponseEntity<String> registerUser(UserModel userModel) throws RuntimeException{
        User user = User.builder()
                .name(userModel.getName())
                .age(userModel.getAge())
                .email(userModel.getEmail())
                .city(userModel.getCity())
                .phoneNumber(userModel.getPhoneNumber())
                .gender(userModel.getGender())
                .password(passEncoder.encode(userModel.getPassword()))
                .build();

        log.info(user.toString());
        try{
            userRepository.save(user);
        }catch (RuntimeException ex){
            throw new SQLException("User cannot be registered", ex.getCause());
        }

        try {
            bankController.openBankAccount(user);
        } catch (RuntimeException ex){
            log.info("User is registered");
            throw new RuntimeException("User is registered but bank account could not be opened", ex.getCause());
        }

        return ResponseEntity.ok("User is registered and Bank account is opened");
    }
}
