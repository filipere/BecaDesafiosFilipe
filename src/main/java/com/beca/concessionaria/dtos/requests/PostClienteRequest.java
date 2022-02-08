package com.beca.concessionaria.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostClienteRequest {

    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    @Size(min = 10, message = "Caracteres insuficientes!")
    private String email;
    private Long idVenda;
}
