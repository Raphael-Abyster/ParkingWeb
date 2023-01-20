package com.abyster.parkingweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "uuid")
    private Integer uuid;
    @Column(name = "immatriculation")
    private String immatriculation;
    @Column(name = "datedebut")
    private Date dateDebut;
    @Column(name = "datefin")
    private Date dateFin;
    @Column(name = "visres")
    private boolean VisRes;

}
