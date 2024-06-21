package com.sportfacility.service;

import com.sportfacility.model.Equipement;
import com.sportfacility.repositories.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {


    @Autowired
    private EquipementRepository equipementRepository;


    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }


    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id).get();
    }

    public Equipement saveEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }


    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public Equipement getEquipementByDesignation(String nom) {
        return equipementRepository.getEquipementByDesignation(nom);
    }


}
