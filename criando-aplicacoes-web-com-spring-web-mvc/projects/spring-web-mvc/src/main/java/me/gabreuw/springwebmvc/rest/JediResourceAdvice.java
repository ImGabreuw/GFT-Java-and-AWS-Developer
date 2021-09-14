package me.gabreuw.springwebmvc.rest;

import me.gabreuw.springwebmvc.exception.JediNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class JediResourceAdvice {

    @ExceptionHandler(JediNotFoundException.class)
    public ResponseEntity<String> handleJediNotFoundException(JediNotFoundException exception) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(exception.getMessage());
    }

}
