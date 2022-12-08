package com.abyster.parkingweb.service.impl;

import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.repository.ParkingRepository;
import com.abyster.parkingweb.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements IParkingService {

    private ParkingRepository parkingRepository;

    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    Logger logger = Logger.getLogger(ParkingServiceImpl.class.getName());

    @Override
    public ParkingDto createParking(ParkingDto dto) {
        logger.info(dto.toString());
        dto.setId(UUID.randomUUID().toString());
        dto.setAdresse(dto.getAdresse());

        return ParkingDto.fromEntity(parkingRepository.save(ParkingDto.toEntity(dto)));
    }

    @Override
    public List<ParkingDto> findAll() {
        return parkingRepository.findAll().stream()
                .map(ParkingDto::fromEntity)
                .collect(Collectors.toList());
    }
}
