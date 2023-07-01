package com.example.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount{

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime lastTransaction;

    @NotNull
    private Boolean isActive;

    @NotNull
    private Integer balance;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerAssociated;

    @OneToMany(mappedBy = "bankAccountID", cascade = CascadeType.ALL)
    private Set<TransactionAmount> transactionAmounts = new HashSet<>();

}