package com.abyster.parkingweb.dto;

import java.util.Date;

public class TicketDto {

    private String uuid;
    private String immatriculation;
    private Date dateDebut;
    private Date dateFin;
    private boolean VisRes;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isVisRes() {
        return VisRes;
    }

    public void setVisRes(boolean visRes) {
        VisRes = visRes;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "uuid=" + uuid +
                ", immatriculation='" + immatriculation + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", VisRes=" + VisRes +
                '}';
    }

}
