package com.sportfacility.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Define  password strength criteria here
        // For example, a strong password might be defined as one that contains at least:
        // - 8 characters
        // - one uppercase letter
        // - one lowercase letter
        // - one number
        // - one special character [!@#$%^&*]

        return password != null
                && password.matches(".*[A-Z].*") // at least one uppercase letter
                && password.matches(".*[a-z].*") // at least one lowercase letter
                && password.matches(".*\\d.*") // at least one number
                && password.matches(".*[!@#$%^&*].*") // at least one special character
                && password.length() >= 8;  // at least 8 characters

    }
}
