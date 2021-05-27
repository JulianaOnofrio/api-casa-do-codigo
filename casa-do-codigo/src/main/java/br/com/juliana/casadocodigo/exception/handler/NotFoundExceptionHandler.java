package br.com.juliana.casadocodigo.exception.handler;

import br.com.juliana.casadocodigo.exception.NotFoundException;
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
