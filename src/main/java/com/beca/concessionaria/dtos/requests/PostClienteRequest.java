package com.beca.concessionaria.dtos.requests;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostClienteRequest {

    @NotBlank
    @Size(min = 3, message = "Caracteres insuficientes")
    @Size(max = 20, message = "Mais caracteres que o permitido")
    private String nome;

    @NotBlank
    @Email
    @Size(min = 10, message = "Caracteres insuficientes!")
    @Size(max = 50, message = "Mais caracteres que o permitido")
    private String email;
    private Long idVenda;
}
