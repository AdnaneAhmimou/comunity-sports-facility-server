package com.sportfacility.repositories;

import com.sportfacility.model.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDetailRepository  extends JpaRepository<ReservationDetail, Long> {
}
