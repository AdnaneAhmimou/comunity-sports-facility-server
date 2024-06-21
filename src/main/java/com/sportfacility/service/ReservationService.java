package com.sportfacility.service;


import com.sportfacility.model.*;
import com.sportfacility.repositories.ClientRepository;
import com.sportfacility.repositories.ReservationRepository;
import com.sportfacility.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Reservation saveReservation(Reservation reservation) {
        // Retrieve the authenticated user
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        // Assuming you have a method to get a User by username
        User user = userRepository.getUserByEmail(username);
        Client client = clientRepository.getClientByEmail(user.getEmail());

        // Set the client to the reservation
        reservation.setClient(client);

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.getInstallateurs().size(); // to fetch installateurs
        reservation.getClient();
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}


