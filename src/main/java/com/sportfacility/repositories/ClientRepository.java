package com.sportfacility.repositories;

import com.sportfacility.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository  extends JpaRepository<Client, Long> {


    Client getClientByCin(String cin);

    Client getClientByEmail(String email);
}
