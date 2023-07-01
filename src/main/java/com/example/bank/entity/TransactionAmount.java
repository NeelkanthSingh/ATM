package com.example.bank.entity;

import com.example.bank.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private Integer transactionID;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @NotNull
    private Integer amount;

    @NotNull
    private LocalDateTime transactionDate;

    @NotNull
    @ManyToOne
    private BankAccount bankAccountID;

    @OneToOne(mappedBy = "transactionAmount", cascade = CascadeType.ALL)
    private BankTransfer bankTransfer;
}
