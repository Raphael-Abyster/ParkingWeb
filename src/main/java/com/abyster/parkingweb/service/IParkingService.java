package com.abyster.parkingweb.service;

import com.abyster.parkingweb.dto.ParkingDto;

import java.util.List;

public interface IParkingService {

    public ParkingDto createParking(ParkingDto dto) throws Exception;

    List<ParkingDto> findAll();

}
