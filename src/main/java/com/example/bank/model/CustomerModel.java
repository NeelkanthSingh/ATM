package com.example.bank.model;
import com.example.bank.utility.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerModel {
    @NotBlank
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    @NotNull
    private Gender gender;

    @NotBlank
    private String city;

    @NotNull
    @DecimalMin(value = "1000000000")
    @DecimalMax(value = "9999999999")
    private Long phoneNumber;

    @NotBlank
    @ValidPassword
    private String password;
}
