package com.beca.concessionaria.dtos.requests;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class PostVendaRequest {

    private Long id;

    @NotBlank
    @NonNull
    @Positive
    private Double preco;

    @NotBlank
    @NonNull
    @Positive
    private Integer quantidade;
}

