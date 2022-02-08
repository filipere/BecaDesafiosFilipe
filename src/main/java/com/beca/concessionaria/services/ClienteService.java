package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.mappers.MapperClienteAtualizar;
import com.beca.concessionaria.mappers.MapperClienteToClienteResponse;
import com.beca.concessionaria.mappers.MapperPostClienteRequestToCliente;
import com.beca.concessionaria.mappers.MapperPostClienteResponse;
import com.beca.concessionaria.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final MapperPostClienteRequestToCliente mapperPostClienteRequestToCliente;
    private final MapperPostClienteResponse mapperPostClienteResponse;
    private final MapperClienteAtualizar mapperClienteAtualizar;
    private final MapperClienteToClienteResponse mapperClienteToClienteResponse;

    public PostClienteResponse adicionar(@NotNull PostClienteRequest postClienteRequest) {
        Cliente cliente = mapperPostClienteRequestToCliente.toModel(postClienteRequest);

        clienteRepository.save(cliente);

        PostClienteResponse clienteResponse = mapperPostClienteResponse.toResponse(cliente);

        return clienteResponse;
    }

    public PostClienteResponse atualizar(PostClienteRequest postClienteRequest, Long id) {

        Cliente cliente = clienteRepository.findById(id).get();

        mapperClienteAtualizar.atualizar(postClienteRequest, cliente);

        clienteRepository.save(cliente);

        return mapperClienteToClienteResponse.toResponse(cliente);
    }

    public PostClienteResponse obter(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();

        return mapperClienteToClienteResponse.toResponse(cliente);
    }

    public void excluir(Long id) {

        clienteRepository.deleteById(id);
    }

    @GetMapping("/clientes")
    public List<PostClienteResponse> mostrar() {
        List<Cliente> listaClientes = clienteRepository.findAll();

        return listaClientes.stream()
                .map(mapperClienteToClienteResponse::toResponse)
                .collect(Collectors
                        .toList());
    }
}