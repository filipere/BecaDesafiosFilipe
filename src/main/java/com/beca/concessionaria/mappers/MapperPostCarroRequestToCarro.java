package com.beca.concessionaria.mappers;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dtos.requests.PostCarroRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPostCarroRequestToCarro {
    public Carro toModel(PostCarroRequest postCarroRequest);
}
