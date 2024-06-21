package com.sportfacility.controller;

import com.sportfacility.model.Reservation;
import com.sportfacility.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @PostMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

//    @PostMapping("/valider-reservation/{id}")
//    public ResponseEntity<String> validerReservation(@PathVariable Long id) {
//        return ResponseEntity.ok(reservationService.validerReservation(id));
//    }


}
