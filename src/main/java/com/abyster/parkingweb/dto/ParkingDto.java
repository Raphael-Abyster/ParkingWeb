package com.abyster.parkingweb.dto;

import java.io.Serializable;

public class ParkingDto implements Serializable {

    private String id;
    private String adresse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
