package com.example.bank.model;

import com.example.bank.entity.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccountModel {

    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Boolean isActive;
    private Integer balance;
    @NotNull
    private User user;

}