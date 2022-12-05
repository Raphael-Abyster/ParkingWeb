package com.abyster.parkingweb;

import java.util.Date;

public class Coupon {

    private Integer uuid;
    private Double pourcentageReduction;
    private Date dateDebutValidite;
    private Date dateFinValidite;

    public Coupon(Integer uuid, Double pourcentageReduction, Date dateDebutValidite, Date dateFinValidite) {
        this.uuid = uuid;
        this.pourcentageReduction = pourcentageReduction;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
    }

}
