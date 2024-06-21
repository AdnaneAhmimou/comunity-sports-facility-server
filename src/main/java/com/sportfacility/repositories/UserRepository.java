package com.sportfacility.repositories;


import com.sportfacility.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);


    User findByUsername(String username);

    User  getUserByEmail(String username);
}
