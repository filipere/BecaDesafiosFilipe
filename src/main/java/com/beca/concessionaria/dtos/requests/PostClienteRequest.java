package com.beca.concessionaria.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostClienteRequest {

    @NotBlank(message = "o campo não pode ser branco!")
    @Size(min = 3, message = "Caracteres insuficientes")
    @Size(max = 20, message = "Mais caracteres que o permitido")
    private String nome;

    @NotBlank(message = "o campo não pode ser branco!")
    @Email
    @Size(min = 10, message = "Caracteres insuficientes!")
    @Size(max = 50, message = "Mais caracteres que o permitido")
    private String email;

    private Long telefone;

    private Long idVenda;
}