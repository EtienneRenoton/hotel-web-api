package dev.hotel.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.dto.CreateReservationDto;
import dev.hotel.dto.MessageErreurDto;
import dev.hotel.entite.Reservation;
import dev.hotel.exception.CreerReservationException;
import dev.hotel.service.ReservationService;

@RestController
@RequestMapping ("reservations")
public class ReservationController {
	  private ReservationService reservationService;

	  public ReservationController(ReservationService reservationService) {
	    this.reservationService = reservationService;
}
	  @PostMapping
	  public ResponseEntity<?> createReservation(@RequestBody CreateReservationDto createReservationDto) {
	    Reservation nouvelleReservation = reservationService.createReservation(createReservationDto);
	  //try {
	    	  return ResponseEntity.ok(nouvelleReservation);
	      
	    /**  } catch (CreerReservationException ex) {
	    	  return ResponseEntity.badRequest().body(new MessageErreurDto(ex.getErreurs())); }
	      */
	    	  
	      }
}