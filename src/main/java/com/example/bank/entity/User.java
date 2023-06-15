package com.example.bank.entity;

import com.example.bank.model.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserID;
    private String name;
    @Column(unique = true)
    private String email;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String city;
    @Column(unique = true)
    private Long phoneNumber;
    private String password;
}
