package com.sportfacility.controller;

import com.sportfacility.model.Installateur;
import com.sportfacility.service.InstallateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/installateur")
@RestController
public class InstallateurController {

    @Autowired
    private InstallateurService installateurService;

    @PostMapping("/save")
    public ResponseEntity<Installateur> saveInstallateur(@RequestBody Installateur installateur) {
        return ResponseEntity.ok(installateurService.saveInstallateur(installateur));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Installateur> updateInstallateur(@PathVariable Long id, @RequestBody Installateur installateur) {
        installateur.setId(id); // Ensure the ID from the URL is set in the installateur object
        return ResponseEntity.ok(installateurService.updateInstallateur(installateur));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInstallateur(@PathVariable Long id) {
        installateurService.deleteInstallateur(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Installateur> getInstallateurById(@PathVariable Long id) {
        return ResponseEntity.ok(installateurService.getInstallateurById(id));
    }

    @GetMapping("/getByNom/{nom}")
    public ResponseEntity<Installateur> getInstallateurByNom(@PathVariable String nom) {
        return ResponseEntity.ok(installateurService.getInstallateurByNom(nom));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Installateur>> getAllInstallateurs() {
        return ResponseEntity.ok(installateurService.getAllInstallateurs());
    }
}
