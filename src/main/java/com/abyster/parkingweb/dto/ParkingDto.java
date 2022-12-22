package com.abyster.parkingweb.dto;

import com.abyster.parkingweb.model.Parking;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ParkingDto implements Serializable {

    private Integer id;
    private String adresse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "ParkingDto{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    public static ParkingDto fromEntity(Parking parking) {
        if (parking == null) {
            return null;
        }
        return ParkingDto.builder()
                .id(parking.getId())
                .adresse(parking.getAdresse())
                .build();
    }

    public static Parking toEntity(ParkingDto dto) {
        if (dto == null) {
            return null;
        }
        Parking parking = new Parking();
        parking.setId(dto.getId());
        parking.setAdresse(dto.getAdresse());
        return parking;
    }

}
