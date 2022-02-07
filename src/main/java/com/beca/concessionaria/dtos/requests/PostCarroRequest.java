package com.beca.concessionaria.dtos.requests;

import lombok.Data;

@Data
public class PostCarroRequest {

    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
}
