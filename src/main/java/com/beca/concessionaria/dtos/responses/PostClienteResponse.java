package com.beca.concessionaria.dtos.responses;

import com.beca.concessionaria.dminios.Venda;
import lombok.Data;

@Data
public class PostClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private Long telefone;

    private Long idVenda;
}