package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.dtos.requests.PostVendaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperVendaAtualizar {
    public void atualizar(PostVendaRequest postVendaRequest, @MappingTarget Venda venda);
}
