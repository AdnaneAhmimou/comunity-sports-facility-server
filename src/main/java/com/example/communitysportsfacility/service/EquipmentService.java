package com.example.communitysportsfacility.service;

import com.example.communitysportsfacility.entity.Equipment;
import com.example.communitysportsfacility.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    // Create new equipment
    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }



    //for more optimisation you need to make it with pagination


    //SearchByCriteria

    // Retrieve all equipment
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // Retrieve equipment by ID
    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
    }

    // Update equipment
    public Equipment updateEquipment( Equipment equipmentDetails) {

        Long idEquipment = equipmentDetails.getId();
        Equipment equipment = equipmentRepository.findById(idEquipment).orElseThrow(() -> new RuntimeException("Equipment not found"));

        equipment.setName(equipmentDetails.getName());
        equipment.setDescription(equipmentDetails.getDescription());

        return equipmentRepository.save(equipment);
    }

    // Delete equipment
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
