package com.beca.concessionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetClienteObterResponse {

    private Long id;
    private String nome;
}
