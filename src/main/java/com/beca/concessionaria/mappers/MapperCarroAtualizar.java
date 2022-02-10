package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dtos.requests.PostCarroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperCarroAtualizar {
    public void atualizar(PostCarroRequest postCarroRequest, @MappingTarget Carro carro);
}