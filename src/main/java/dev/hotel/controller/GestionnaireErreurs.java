package dev.hotel.controller;

import dev.hotel.dto.MessageErreurDto;
import dev.hotel.exception.CreerReservationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestionnaireErreurs {

    @ExceptionHandler(CreerReservationException.class)
    public ResponseEntity<MessageErreurDto> traiterCreerReservationException(CreerReservationException ex) {
        return ResponseEntity.badRequest().body(new MessageErreurDto(ex.getErreurs()));
    }
}
