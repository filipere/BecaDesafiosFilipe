package com.beca.concessionaria.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostVendaRequest {

    private Long id;
    private Double preco;
    private Integer quantidade;
}

