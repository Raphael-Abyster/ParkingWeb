package com.abyster.parkingweb.service;

import com.abyster.parkingweb.dto.ParkingDto;

public interface IParkingService {

    public ParkingDto createParking(ParkingDto dto) throws Exception;

}
