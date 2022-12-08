package com.abyster.parkingweb.repository;

import com.abyster.parkingweb.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
