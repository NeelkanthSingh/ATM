package com.example.bank.repository;

import com.example.bank.entity.BankTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransferRepository extends JpaRepository<BankTransfer, Integer> {
}
