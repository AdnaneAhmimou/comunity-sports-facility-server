package com.sportfacility.model;

import com.sportfacility.enums.StatusReservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private StatusReservation status;

    @ManyToMany
    @JoinTable(
            name = "reservation_equipement",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements;

    @ManyToMany
    @JoinTable(
            name = "reservation_installateur",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "installateur_id")
    )
    private List<Installateur> installateurs;
}

