package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount{

    @Id
    @GeneratedValue
    private Integer accountID;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private Integer balance;
    @ManyToOne
    private User user;
}