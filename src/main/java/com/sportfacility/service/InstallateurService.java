package com.sportfacility.service;


import com.sportfacility.model.Installateur;
import com.sportfacility.repositories.InstallateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallateurService {



    @Autowired
    private InstallateurRepository installateurRepository;


    public void deleteInstallateur(Long id) {
        installateurRepository.deleteById(id);
    }


    public List<Installateur> getAllInstallateurs() {
        return installateurRepository.findAll();
    }

    public Installateur getInstallateurById(Long id) {
        return installateurRepository.findById(id).get();
    }

    @Transactional
    public Installateur saveInstallateur(Installateur installateur) {
        return installateurRepository.save(installateur);
    }


public Installateur updateInstallateur(Installateur installateur) {
        return installateurRepository.save(installateur);
    }

    public Installateur getInstallateurByNom(String nom) {
        return installateurRepository.getInstallateurByNom(nom);
    }

}
