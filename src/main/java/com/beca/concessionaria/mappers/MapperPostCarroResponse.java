package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dtos.responses.PostCarroResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPostCarroResponse {
    public PostCarroResponse toResponse(Carro carro);
}
