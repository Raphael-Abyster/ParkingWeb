package com.abyster.parkingweb.service.impl;

import ch.qos.logback.core.spi.ErrorCodes;
import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.dto.TicketDto;
import com.abyster.parkingweb.repository.ParkingRepository;
import com.abyster.parkingweb.service.IParkingService;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public ParkingDto findById(Integer id) {
        if (id==null){
            return null;
        }

        return parkingRepository.findById(id)
                .map(ParkingDto::fromEntity).orElseThrow(() ->
                        new EntityNotFoundException("Aucune category avec l'id = " + id + "n'a été trouvé dans la base de donnée"));
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            return;
        }
        parkingRepository.deleteById(id);
    }

}
