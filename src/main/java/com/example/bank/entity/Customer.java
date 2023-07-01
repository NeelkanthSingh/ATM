package com.example.bank.entity;

import com.example.bank.model.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private String city;

    @NotNull
    @Column(unique = true)
    private Long phoneNumber;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "customerAssociated", cascade = CascadeType.ALL)
    private Set<BankAccount> bankAccounts = new HashSet<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Employee employeeAssociated;
}
