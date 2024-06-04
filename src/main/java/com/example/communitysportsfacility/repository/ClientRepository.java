package com.example.communitysportsfacility.repository;

import com.example.communitysportsfacility.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
