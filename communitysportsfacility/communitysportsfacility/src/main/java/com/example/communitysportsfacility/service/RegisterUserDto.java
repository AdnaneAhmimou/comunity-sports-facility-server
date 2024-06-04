package com.example.communitysportsfacility.service;


import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterUserDto {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

}