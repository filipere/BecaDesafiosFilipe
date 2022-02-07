package com.beca.concessionaria.dtos.requests;

import lombok.Data;

@Data
public class PostVendaRequest {

    private Long id;
    private Double preco;
    private Integer quantidade;
}

