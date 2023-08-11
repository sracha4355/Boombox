package com.boombox.exceptions.handlers;

import com.boombox.exceptions.artist.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ArtistExceptionHandler {
    @ExceptionHandler(ArtistNotFoundException.class)
    public ResponseEntity<Object> handleArtistNotFoundException(ArtistNotFoundException ex){
        ArtistException exception  = new ArtistException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArtistCouldNotBeCreatedException.class)
    public ResponseEntity<Object> handleArtistCouldNotBeCreatedException(ArtistCouldNotBeCreatedException ex){
        ArtistException exception = new ArtistException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
        Map<String, Object> res = new HashMap<>();
        res.put("ERROR DETAILS",  exception);
        return  new ResponseEntity<>(res, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ArtistAlreadyExistsException.class)
    public ResponseEntity<Object> handleArtistAlreadyExistsException(ArtistAlreadyExistsException ex){
        ArtistException exception = new ArtistException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.UNPROCESSABLE_ENTITY
        );

        Map<String, Object> res = new HashMap<>();
        res.put("ERROR DETAILS", exception);
        res.put("ARTIST", ex.getExistingArtist());
        return new ResponseEntity<>(res, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ArtistCouldNotBeDeletedException.class)
    public ResponseEntity<Object> handleArtistCouldNotDeletedException(ArtistCouldNotBeDeletedException ex){
        ArtistException exception = new ArtistException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        Map<String,Object> res = new HashMap<>();
        res.put("ERROR DETAILS", exception);
        return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
    }


}
