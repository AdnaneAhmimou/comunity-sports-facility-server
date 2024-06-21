package com.sportfacility.service;

import com.sportfacility.model.ReservationDetail;
import com.sportfacility.repositories.ReservationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationDetailService {


        @Autowired
        private ReservationDetailRepository reservationDetailRepository;

        public void deleteReservationDetail(Long id) {
            reservationDetailRepository.deleteById(id);
        }

        public List<ReservationDetail> getAllReservationDetails() {
            return reservationDetailRepository.findAll();
        }


        public ReservationDetail getReservationDetailById(Long id) {
            return reservationDetailRepository.findById(id).get();
        }

        public ReservationDetail saveReservationDetail(ReservationDetail reservationDetail) {

            return reservationDetailRepository.save(reservationDetail);
        }


        public ReservationDetail updateReservationDetail(ReservationDetail reservationDetail) {
            return reservationDetailRepository.save(reservationDetail);
        }

        public List<ReservationDetail> saveListResaDet(List<ReservationDetail> reservationDetails) {
            return reservationDetailRepository.saveAll(reservationDetails);
        }



}
