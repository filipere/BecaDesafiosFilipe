package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.dtos.requests.PostVendaRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPostVendaRequestToVenda {
    public Venda toModel(PostVendaRequest postVendaRequest);
}