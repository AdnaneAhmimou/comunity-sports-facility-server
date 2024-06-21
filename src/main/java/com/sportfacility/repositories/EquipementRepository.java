package com.sportfacility.repositories;

import com.sportfacility.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    Equipement getEquipementByDesignation(String nom);
}
