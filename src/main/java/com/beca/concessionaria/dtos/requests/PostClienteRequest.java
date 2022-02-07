package com.beca.concessionaria.dtos.requests;

import lombok.Data;

@Data
public class PostClienteRequest {

    private String nome;
    private Long idVenda;
}
