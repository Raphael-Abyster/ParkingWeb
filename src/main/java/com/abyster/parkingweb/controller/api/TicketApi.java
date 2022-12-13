package com.abyster.parkingweb.controller.api;


import com.abyster.parkingweb.dto.TicketDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abyster.parkingweb.utils.Contants.TICKET_ENDPOINT;

@Api(TICKET_ENDPOINT)
public interface TicketApi {

    @PostMapping(value = TICKET_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un ticket", notes = "Cette methode permet d'enregistrer un ticket", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet ticket cree"),
            @ApiResponse(code = 400,message = "L'objet ticket n'est pas valide")
    })
    ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto dto);

    @GetMapping(value = TICKET_ENDPOINT + "{idTicket}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un ticket", notes = "Cette methode permet de chercher un ticket par son id", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le ticket est trouvé dans la base de donnée"),
            @ApiResponse(code = 404, message = "Aucun ticket n'existe dans la base de donnée avec l'id fourni")
    })
    TicketDto findById(@PathVariable("idTicket") Integer id);

    @GetMapping(value = TICKET_ENDPOINT+"/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des tickets", notes = "Cette methode permet de renvoyer la liste des tickets qui existe dans la base de donné", responseContainer = "List<TicketDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des articles / Une liste vide"),
    })
    List<TicketDto> findAllTickets();

    @DeleteMapping(value = TICKET_ENDPOINT+"/delete/{idArticle}")
    @ApiOperation(value = "Supprimer un ticket", notes = "Cette methode permet de supprimer un ticket par son id", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le ticket a été supprimer"),
    })
    void delete(@PathVariable("idTicket") Integer id);

}
