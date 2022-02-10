package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperClienteAtualizar {
    public void atualizar (PostClienteRequest postClienteRequest, @MappingTarget Cliente cliente);
}