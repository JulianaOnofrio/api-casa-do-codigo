package br.com.juliana.casadocodigo.exception.handler;

import br.com.juliana.casadocodigo.exception.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ValidationErrorDTO> handle(MethodArgumentNotValidException e) {
        return e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorDTO(error.getField(), this.messageSource.getMessage(error, LocaleContextHolder.getLocale())))
                .collect(Collectors.toList());
    }

}