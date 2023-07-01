package com.example.bank.repository;

import com.example.bank.entity.TransactionAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionAmountRepository extends JpaRepository<TransactionAmount, Integer> {
}
