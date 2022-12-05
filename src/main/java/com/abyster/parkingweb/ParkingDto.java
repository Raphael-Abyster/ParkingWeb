package com.abyster.parkingweb;

public class ParkingDto {

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
}
