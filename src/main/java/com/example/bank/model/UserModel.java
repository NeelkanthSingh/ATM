package com.example.bank.model;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private String name;

    @Email
    private String email;

    @Min(18)
    private Integer age;

    private Gender gender;

    private String city;

    private Long phoneNumber;
}
