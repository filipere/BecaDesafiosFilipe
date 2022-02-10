package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.dtos.responses.PostVendaResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MapperVendaToVendaResponse {
    public PostVendaResponse toResponse(Venda venda);
}