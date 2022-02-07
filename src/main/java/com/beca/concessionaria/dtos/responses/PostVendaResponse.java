package com.beca.concessionaria.dtos.responses;

import lombok.Data;

@Data
public class PostVendaResponse {

    private Long id;
    private Double preco;
    private Integer quantidade;
}