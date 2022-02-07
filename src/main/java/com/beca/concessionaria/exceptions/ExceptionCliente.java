package com.beca.concessionaria.exceptions;

import lombok.Data;

@Data
public class ExceptionCliente extends RuntimeException{
    public ExceptionCliente(String mensagem) {
        super(mensagem);
    }
}
