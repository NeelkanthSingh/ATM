package com.example.bank.entity;

import com.example.bank.model.TransferType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransfer {

    @Id
    @GeneratedValue
    private Integer TransferID;

    @NotNull
    @OneToOne
    private TransactionAmount transactionAmount;

    @NotNull
    @OneToOne
    private BankAccount sendersAccount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransferType transferType;
}
