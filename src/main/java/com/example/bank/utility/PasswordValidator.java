package com.example.bank.utility;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if(password.length() < 8)   return false;

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*()\\-_+=|\\[\\]{};':\"\\\\<>,.?/~`].*")) {
            return false;
        }

        // Check for at least one number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for at least one lowercase alphabet character
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for at least one UPPERCASE alphabet character
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }
}
