package com.example.bank.model;

import com.example.bank.entity.User;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccountModel {

    @NotBlank
    private LocalDateTime createdAt;
    @NotBlank
    private Boolean isActive;
    private Integer balance=0;
    @NotBlank
    private User user;
}