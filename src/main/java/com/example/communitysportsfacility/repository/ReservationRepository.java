package com.example.communitysportsfacility.repository;

import com.example.communitysportsfacility.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
