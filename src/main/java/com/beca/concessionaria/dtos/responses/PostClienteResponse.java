package com.beca.concessionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PostClienteResponse {

    private String nome;
    private Long idVenda;
}
