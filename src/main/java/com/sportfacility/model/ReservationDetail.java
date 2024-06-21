package com.sportfacility.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double fraisInstallation;

    private String description;

//    @ManyToOne
//    private Equipement equipement;

//    @Enumerated(EnumType.STRING)
//    private TypeEquipement typeEquipement;

//    @ManyToOne
//    private Reservation reservation;
}
