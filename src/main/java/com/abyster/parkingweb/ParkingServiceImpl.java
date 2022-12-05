package com.abyster.parkingweb;

import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ParkingServiceImpl implements IParkingService {

    Logger logger = Logger.getLogger(ParkingServiceImpl.class.getName());

    @Override
    public ParkingDto createParking(ParkingDto dto) {
        logger.info(dto.toString());
        dto.setId(UUID.randomUUID().toString());

        return dto;
    }
}
