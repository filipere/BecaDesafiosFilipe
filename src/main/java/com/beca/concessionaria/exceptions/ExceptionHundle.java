package com.beca.concessionaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHundle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionPadrao> hundle(ExceptionErros e) {
        ExceptionPadrao exceptionPadrao = new ExceptionPadrao();

        exceptionPadrao.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        exceptionPadrao.setMensagem("Invalido");

        return ResponseEntity.status(HttpStatus.valueOf(exceptionPadrao.getStatus())).body(exceptionPadrao);
    }
}
