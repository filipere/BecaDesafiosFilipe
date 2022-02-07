package com.beca.concessionaria.exceptions;

import lombok.Data;

@Data
public class ExceptionCarro extends RuntimeException {
    public ExceptionCarro(String mensagem) {
        super(mensagem);
    }
}
