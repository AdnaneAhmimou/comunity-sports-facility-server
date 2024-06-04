package com.example.communitysportsfacility.service;


import com.example.communitysportsfacility.entity.Client;
import com.example.communitysportsfacility.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {


     private ClientRepository clientRepository;


     public ClientService(ClientRepository clientRepository) {
         this.clientRepository = clientRepository;
     }


     public Client saveClient(Client client) {
         return clientRepository.save(client);
     }

     public Client getClientById(Long id) {
         return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
     }

     public void deleteClient(Long id) {
         clientRepository.deleteById(id);
     }

        public Client updateClient(Client client) {
            return clientRepository.save(client);
        }

        public List<Client> getAllClients() {
            return clientRepository.findAll();
        }

}
