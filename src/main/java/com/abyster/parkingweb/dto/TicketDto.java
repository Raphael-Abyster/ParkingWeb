package com.abyster.parkingweb.dto;

import com.abyster.parkingweb.model.Parking;
import com.abyster.parkingweb.model.Ticket;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
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

    public static TicketDto fromEntity(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        return TicketDto.builder()
                .uuid(ticket.getUuid())
                .immatriculation(ticket.getImmatriculation())
                .dateDebut(ticket.getDateDebut())
                .dateFin(ticket.getDateFin())
                .VisRes(ticket.isVisRes())
                .build();
    }

    public static Ticket toEntity(TicketDto dto) {
        if (dto == null) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setUuid(dto.getUuid());
        ticket.setImmatriculation(dto.getImmatriculation());
        ticket.setDateDebut(ticket.getDateDebut());
        ticket.setDateFin(ticket.getDateFin());
        ticket.setVisRes(ticket.isVisRes());
        return ticket;
    }

}
