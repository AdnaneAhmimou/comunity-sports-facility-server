package com.sportfacility.controller;

import com.sportfacility.model.Client;
import com.sportfacility.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/update")
    // @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/getByCin/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable String cin) {
        return ResponseEntity.ok(clientService.getClientByCin(cin));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Client> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(clientService.findByEmail(email));
    }
}
