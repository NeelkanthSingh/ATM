package com.example.bank.entity;

import com.example.bank.model.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionAmount {

    @Id
    @GeneratedValue
    private Integer TransactionID;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Integer amount;
    private LocalDateTime transactionDate;
    @ManyToOne
    private BankAccount bankAccountID;
}
