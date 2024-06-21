package com.sportfacility.repositories;

import com.sportfacility.model.Installateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallateurRepository extends JpaRepository<Installateur, Long> {
    Installateur getInstallateurByNom(String nom);
}
