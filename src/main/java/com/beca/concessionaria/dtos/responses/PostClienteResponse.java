package com.beca.concessionaria.dtos.responses;

import lombok.Data;

@Data
public class PostClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private Long telefone;
}