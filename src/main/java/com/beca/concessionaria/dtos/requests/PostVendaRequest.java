package com.beca.concessionaria.dtos.requests;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class PostVendaRequest {

//    @NotBlank
//    @NonNull
//    @Positive
    private Double valor;

//    @NotBlank
//    @NotNull
//    @Positive
    private Long qtd;
}