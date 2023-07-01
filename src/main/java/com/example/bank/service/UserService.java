package com.example.bank.service;

import com.example.bank.controller.BankController;
import com.example.bank.entity.Customer;
import com.example.bank.exception.SQLException;
import com.example.bank.model.CustomerModel;
import com.example.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final CustomerRepository customerRepository;
    private final BankController bankController;
    private final PasswordEncoder passEncoder;

    public ResponseEntity<String> registerUser(CustomerModel customerModel) throws RuntimeException{
        Customer customer = Customer.builder()
                .name(customerModel.getName())
                .age(customerModel.getAge())
                .email(customerModel.getEmail())
                .city(customerModel.getCity())
                .phoneNumber(customerModel.getPhoneNumber())
                .gender(customerModel.getGender())
                .password(passEncoder.encode(customerModel.getPassword()))
                .build();

        log.info(customer.toString());
        try{
            customerRepository.save(customer);
        }catch (RuntimeException ex){
            throw new SQLException("User cannot be registered", ex.getCause());
        }

        try {
            bankController.openBankAccount(customer);
        } catch (RuntimeException ex){
            log.info("User is registered");
            throw new RuntimeException("User is registered but bank account could not be opened", ex.getCause());
        }

        return ResponseEntity.ok("User is registered and Bank account is opened");
    }
}
