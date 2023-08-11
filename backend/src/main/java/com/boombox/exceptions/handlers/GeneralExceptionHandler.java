package com.boombox.exceptions.handlers;

import com.boombox.exceptions.general.EntityCouldNotBeCreated;
import com.boombox.exceptions.general.EntityNotFoundException;
import com.boombox.exceptions.general.GeneralExceptionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){
        GeneralExceptionWrapper wrapper = new GeneralExceptionWrapper(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(wrapper, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityCouldNotBeCreated.class)
    public ResponseEntity<Object> handleEntityCouldNotBeCreated(EntityCouldNotBeCreated ex){
        GeneralExceptionWrapper wrapper = createWrapper(ex);
        return new ResponseEntity<>(wrapper, HttpStatus.NOT_FOUND);
    }

    private GeneralExceptionWrapper createWrapper(RuntimeException ex){
        return new GeneralExceptionWrapper(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
    }



}
