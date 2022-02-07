package com.beca.concessionaria.dtos.responses;

import lombok.Data;

@Data
public class PostCarroResponse {
    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
}
