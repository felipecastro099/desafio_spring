package com.example.praticaspringboot.exceptions;

import com.example.praticaspringboot.dto.exceptions.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> sellerNotFound(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(notFoundException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<?> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> listErrors = new ArrayList<>();

        fieldErrors.forEach(list -> listErrors.add(new ExceptionDTO(list.getField() + ": " + list.getDefaultMessage())));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErrors);
    }
}
