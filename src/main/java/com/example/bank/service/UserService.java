package com.example.bank.service;

import com.example.bank.entity.User;
import com.example.bank.exception.SQLException;
import com.example.bank.model.UserModel;
import com.example.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<String> registerUser(UserModel userModel) throws RuntimeException{
        User user = User.builder()
                .name(userModel.getName())
                .age(userModel.getAge())
                .email(userModel.getEmail())
                .city(userModel.getCity())
                .phoneNumber(userModel.getPhoneNumber())
                .gender(userModel.getGender())
                .build();

        log.info(user.toString());
        try{
            userRepository.save(user);
        }catch (RuntimeException ex){
            throw new SQLException("Failed to save the user information", ex.getCause());
        }

        return ResponseEntity.ok("User is registered");
    }
}
