package com.example.communitysportsfacility.controller;

import com.example.communitysportsfacility.entity.Reservation;
import com.example.communitysportsfacility.entity.ReservationStatus;
import com.example.communitysportsfacility.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {

        Reservation savedReservation = reservationService.saveReservation(reservation);

        return  ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return ResponseEntity.ok(updatedReservation);
    }
}
