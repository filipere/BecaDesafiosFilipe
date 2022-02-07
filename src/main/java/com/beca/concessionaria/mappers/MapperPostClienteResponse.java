package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPostClienteResponse {
    public PostClienteResponse toResponse(Cliente cliente);
}
