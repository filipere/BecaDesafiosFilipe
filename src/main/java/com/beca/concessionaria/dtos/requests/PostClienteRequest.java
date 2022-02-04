package com.beca.concessionaria.dtos.requests;

import com.beca.concessionaria.dminios.Venda;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostClienteRequest {

    private String nome;
    private Long idVenda;
}
