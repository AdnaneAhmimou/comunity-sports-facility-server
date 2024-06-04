package com.example.communitysportsfacility.service;

import com.example.communitysportsfacility.entity.*;
import com.example.communitysportsfacility.repository.ClientRepository;
import com.example.communitysportsfacility.repository.ReservationRepository;
import com.example.communitysportsfacility.repository.EquipmentRepository;
import com.example.communitysportsfacility.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;



    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new reservation
    public Reservation saveReservation(Reservation reservation) {


        Client client = clientRepository.findById(reservation.getClient().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        // Retrieve the user

        // Ensure all equipment items are managed by the EntityManager
        for (Equipment equipment : reservation.getEquipment()) {
            Optional<Equipment> existingEquipment = equipmentRepository.findById(equipment.getId());
            if (existingEquipment.isPresent()) {
                equipment = existingEquipment.get();
            } else {
                equipment = equipmentRepository.save(equipment);
            }
        }

        // Associate the reservation with the user
        reservation.setClient(client);


        // Set default status if not provided
        if (reservation.getStatus() == null) {
            reservation.setStatus(ReservationStatus.IN_PROGRESS);
        }

        return reservationRepository.save(reservation);
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Retrieve a reservation by ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    // Update the status of a reservation
    public Reservation updateReservationStatus(Long id, ReservationStatus status) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setStatus(status);
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        Reservation reservation1 = reservationRepository.findById(reservation.getId()).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation1.setInstallationLocation(reservation.getInstallationLocation());
        reservation1.setSpace(reservation.getSpace());
        reservation1.setEquipmentType(reservation.getEquipmentType());
        reservation1.setProvisionalDate(reservation.getProvisionalDate());
        reservation1.setStatus(reservation.getStatus());
        reservation1.setClient(reservation.getClient());
        reservation1.setEquipment(reservation.getEquipment());
        return reservationRepository.save(reservation1);
    }
}
