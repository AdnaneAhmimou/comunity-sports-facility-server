package com.sportfacility.controller;

import com.sportfacility.model.Equipement;
import com.sportfacility.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipement")
public class EquipementController {

    @Autowired
    private EquipementService equipementService;

    @PostMapping("/save")
    public ResponseEntity<Equipement> saveEquipement(@RequestBody Equipement equipement) {
        return ResponseEntity.ok(equipementService.saveEquipement(equipement));
    }

    @PostMapping("/update")
    public ResponseEntity<Equipement> updateEquipement(@RequestBody Equipement equipement) {
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        return ResponseEntity.ok(equipementService.getEquipementById(id));
    }

    @GetMapping("/getByDesignation/{nom}")
    public ResponseEntity<Equipement> getEquipementByDesignation(@PathVariable String nom) {
        return ResponseEntity.ok(equipementService.getEquipementByDesignation(nom));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        return ResponseEntity.ok(equipementService.getAllEquipements());
    }
}
