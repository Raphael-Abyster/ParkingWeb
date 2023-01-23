package com.abyster.parkingweb.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.persistence.EntityNotFoundException;
import com.abyster.parkingweb.dto.ParkingDto;
import com.abyster.parkingweb.model.Parking;
import com.abyster.parkingweb.repository.ParkingRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParkingServiceImplTest {

    private ParkingRepository parkingRepository = mock(ParkingRepository.class);
    @InjectMocks
    private ParkingServiceImpl parkingServiceImpl;

    @BeforeAll
    void setUp() {
        parkingServiceImpl = new ParkingServiceImpl(parkingRepository);
    }


    // erreur sur ce test unitaire si on enlève pas la ligne "logger.info(dto.toString());" de la fonction createParking
    @Test
    public void testCreateParking() {
        ParkingDto dto = ParkingDto.builder().id(1).adresse("address1").build();
        Parking parking = new Parking(1, "address1");
        when(parkingRepository.save(parking)).thenReturn(parking);

        ParkingDto result = parkingServiceImpl.createParking(dto);

        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getAdresse(), result.getAdresse());
        verify(parkingRepository, times(1)).save(parking);
    }

    @Test
    void findAll() {
        // Given
        Parking parking1 = new Parking(1, "adresse 1");
        Parking parking2 = new Parking(2, "adresse 2");
        List<Parking> parkings = Arrays.asList(parking1, parking2);
        when(parkingRepository.findAll()).thenReturn(parkings);

        // When
        List<ParkingDto> parkingDtos = parkingServiceImpl.findAll();

        // Then
        assertEquals(2, parkingDtos.size());
        assertEquals(1, parkingDtos.get(0).getId().intValue());
        assertEquals("adresse 1", parkingDtos.get(0).getAdresse());
        assertEquals(2, parkingDtos.get(1).getId().intValue());
        assertEquals("adresse 2", parkingDtos.get(1).getAdresse());
    }

    @Test
    void findById_whenIdIsNull_shouldReturnNull() {
        // Arrange
        Integer id = null;

        // Act
        ParkingDto result = parkingServiceImpl.findById(id);

        // Assert
        assertEquals(null, result);
    }

    @Test
    void findById_whenIdIsValid_shouldReturnParkingDto() {
        // Arrange
        Integer id = 1;
        Parking parking = new Parking();
        parking.setId(id);
        when(parkingRepository.findById(id)).thenReturn(java.util.Optional.of(parking));

        // Act
        ParkingDto result = parkingServiceImpl.findById(id);

        // Assert
        assertEquals(ParkingDto.fromEntity(parking), result);
        assertEquals(1, result.getId());
    }

    @Test
    void findById_whenIdIsInvalid_shouldThrowEntitiesNotFoundException() {
        // Arrange
        Integer id = 2;
        when(parkingRepository.findById(id)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> {
            parkingServiceImpl.findById(id);
        });
    }
}
