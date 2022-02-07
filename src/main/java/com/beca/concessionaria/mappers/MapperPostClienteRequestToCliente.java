package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPostClienteRequestToCliente {
    public Cliente toModel(PostClienteRequest postClienteRequest);
}
