package com.sportfacility.service;

import com.sportfacility.model.Client;
import com.sportfacility.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientByCin(String cin) {
        return clientRepository.getClientByCin(cin);
    }

    public Client findByEmail(String email) {
        return clientRepository.getClientByEmail(email);
    }




}
