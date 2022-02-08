package com.beca.concessionaria.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostCarroRequest {

    @NotBlank
    @Size(min = 3, message = "minimo de 4 caracteres")
    private String marca;

    @NotBlank
    @Size(min = 3, message = "minimo de 4 caracteres")
    private String modelo;

    @NotBlank
    @Size(min = 4, message = "minimo de 4 caracteres")
    private String cor;

    @NotBlank
    @Size(min = 4, message = "O ano precisa ter 4 caracteres")
    private Integer ano;
}
