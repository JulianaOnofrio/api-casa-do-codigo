package br.com.juliana.casadocodigo.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handle(NotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
