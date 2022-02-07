package com.beca.concessionaria.exceptions;

import lombok.Data;

@Data
public class ExceptionVenda extends RuntimeException {
    public ExceptionVenda(String mensagem) {
        super(mensagem);
    }
}
