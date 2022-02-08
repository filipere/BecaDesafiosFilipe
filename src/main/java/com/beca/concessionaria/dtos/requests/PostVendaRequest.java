package com.beca.concessionaria.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class PostVendaRequest {

    private Long id;

    @NotBlank
    @Positive
    private Double preco;

    @NotBlank
    @Positive
    private Integer quantidade;
}

