package com.example.communitysportsfacility.service;

import com.example.communitysportsfacility.entity.RoleType;
import com.example.communitysportsfacility.entity.User;
import com.example.communitysportsfacility.entity.UserRole;
import com.example.communitysportsfacility.repository.UserRepository;
import com.example.communitysportsfacility.repository.UserRoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            UserRoleRepository userRoleRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

//    public User signup(RegisterUserDto input) {
//        User user = new User();
//        user.setFirstName(input.getFirstName());
//        user.setLastName(input.getLastName());
//        user.setEmail(input.getEmail());
//        user.setPassword(passwordEncoder.encode(input.getPassword()));
//
//        // Assign role to user
//        RoleType roleType = RoleType.valueOf(input.getRole().toUpperCase());
//        UserRole userRole = new UserRole();
//        userRole.setRole(roleType);
//        user.setRoles(Collections.singleton(userRole));
//
//        return userRepository.save(user);
//    }
    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        // Create and save UserRole
        RoleType roleType = RoleType.valueOf(input.getRole().toUpperCase());
        UserRole userRole = new UserRole();
        userRole.setRole(roleType);
        userRoleRepository.save(userRole);

        // Assign role to user
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}