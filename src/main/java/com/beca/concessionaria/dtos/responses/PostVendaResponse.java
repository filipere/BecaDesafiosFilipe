package com.beca.concessionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PostVendaResponse {

    private Long id;
    private Double preco;
    private Integer quantidade;
}
