package com.example.communitysportsfacility.controller;

import com.example.communitysportsfacility.entity.Equipment;
import com.example.communitysportsfacility.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {

        Equipment savedEquipment = equipmentService.saveEquipment(equipment);

        return ResponseEntity.ok(savedEquipment);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipment() {

        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long id) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        return ResponseEntity.ok(equipment);
    }

    @PutMapping("/update")
//    @PreAuthorize("hasRole('ADMIN')")
    public Equipment updateEquipment( @RequestBody Equipment equipmentDetails) {
        return equipmentService.updateEquipment(equipmentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}