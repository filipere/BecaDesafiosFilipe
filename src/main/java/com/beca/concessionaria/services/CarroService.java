package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dtos.requests.PostCarroRequest;
import com.beca.concessionaria.dtos.responses.PostCarroResponse;
import com.beca.concessionaria.mappers.MapperCarroAtualizar;
import com.beca.concessionaria.mappers.MapperCarroToCarroResponse;
import com.beca.concessionaria.mappers.MapperPostCarroRequestToCarro;
import com.beca.concessionaria.mappers.MapperPostCarroResponse;
import com.beca.concessionaria.repositories.CarroRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;
    private final MapperPostCarroRequestToCarro mapperPostCarroRequestToCarro;
    private final MapperPostCarroResponse mapperPostCarroResponse;
    private  final MapperCarroToCarroResponse mapperCarroToCarroResponse;
    private final MapperCarroAtualizar mapperCarroAtualizar;

    public PostCarroResponse adicionar(@NonNull PostCarroRequest postCarroRequest) {
        Carro carro = mapperPostCarroRequestToCarro.toModel(postCarroRequest);

        carroRepository.save(carro);

        PostCarroResponse carroResponse = mapperPostCarroResponse.toResponse(carro);

        return carroResponse;
    }

    public PostCarroResponse atualizar(PostCarroRequest postCarroRequest, Long id) {
        Carro carro = carroRepository.findById(id).get();

        mapperCarroAtualizar.atualizar(postCarroRequest, carro);

        carroRepository.save(carro);

        return mapperCarroToCarroResponse.toResponse(carro);
    }

    public PostCarroResponse obter(Long id) {
        Carro carro = carroRepository.findById(id).get();

        return mapperCarroToCarroResponse.toResponse(carro);
    }

    public void excluir(Long id) {

        carroRepository.deleteById(id);
    }

    public List<PostCarroResponse> mostrar() {
        List<Carro> listaCarro = carroRepository.findAll();

        return listaCarro.stream()
                .map(mapperCarroToCarroResponse::toResponse)
                .collect(Collectors
                        .toList());
    }
}