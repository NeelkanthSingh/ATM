package com.example.bank.entity;

import com.example.bank.model.EmployeeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "employee")
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeType position;

    @NotNull
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
