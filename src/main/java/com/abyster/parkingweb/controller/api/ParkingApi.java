package com.abyster.parkingweb.controller.api;

import com.abyster.parkingweb.dto.ParkingDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.abyster.parkingweb.utils.Contants.PARKING_ENDPOINT;

public interface ParkingApi {

    @PostMapping(value = PARKING_ENDPOINT + "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un parking", notes = "Cette methode permet d'enregistrer un parking", response = ParkingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet parking cree"),
            @ApiResponse(code = 400,message = "L'objet parking n'est pas valide")
    })
    ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto dto);

    @GetMapping(value = PARKING_ENDPOINT + "{idParking}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un parking", notes = "Cette methode permet de chercher un parking par son id", response = ParkingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le parking est trouvé dans la base de donnée"),
            @ApiResponse(code = 404, message = "Aucun parking n'existe dans la base de donnée avec l'id fourni")
    })
    ParkingDto findById(@PathVariable("idParking") Integer id);

    @GetMapping(value = PARKING_ENDPOINT+"/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des parking", notes = "Cette methode permet de renvoyer la liste des parking qui existe dans la base de donné", responseContainer = "List<ParkingDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des parkings / Une liste vide"),
    })
    List<ParkingDto> findAllParkings();

}
