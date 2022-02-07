package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.dtos.requests.PostVendaRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.dtos.responses.PostVendaResponse;
import com.beca.concessionaria.mappers.MapperPostVendaRequestToVenda;
import com.beca.concessionaria.mappers.MapperVendaAtualizar;
import com.beca.concessionaria.mappers.MapperVendaToVendaResponse;
import com.beca.concessionaria.repositories.ClienteRepository;
import com.beca.concessionaria.repositories.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final MapperPostVendaRequestToVenda mapperPostVendaRequestToVenda;
    private final MapperVendaToVendaResponse mapperVendaToVendaResponse;
    private final MapperVendaAtualizar mapperAtualizar;

    public PostVendaResponse adicionar(PostVendaRequest postVendaRequest) {

        Venda vendaObtida = vendaRepository.getById(postVendaRequest.getId());

        Venda venda = mapperPostVendaRequestToVenda.toModel(postVendaRequest);

        Cliente cliente = new Cliente();
        cliente.setId(postVendaRequest.getId());
        cliente.setVenda(vendaObtida);

        Cliente salvando = clienteRepository.save(cliente);

        PostVendaResponse vendaResponse = mapperVendaToVendaResponse.toResponse(venda);

        PostVendaResponse postVendaResponse = new PostVendaResponse();
        postVendaResponse.setId(salvando.getId());

        return vendaResponse;
    }

    public PostVendaResponse atualizar(PostVendaRequest postVendaRequest, Long id) {
        Venda vendaObter = vendaRepository.getById(id);

        mapperAtualizar.atualizar(postVendaRequest, vendaObter);

        vendaRepository.save(vendaObter);

        PostVendaResponse postVendaResponse = mapperVendaToVendaResponse.toResponse(vendaObter);

        return postVendaResponse;
    }

    public PostVendaResponse obter(Long id) {
        Venda venda = vendaRepository.findById(id).get();

        return mapperVendaToVendaResponse.toResponse(venda);
    }

    public void excluir(Long id) {
        vendaRepository.deleteById(id);

    }
    @GetMapping("/vendas")
    public List<PostVendaResponse> mostrar() {
        List<Venda> ListaVenda = vendaRepository.findAll();

        return ListaVenda.stream()
                .map(mapperVendaToVendaResponse::toResponse)
                .collect(Collectors
                        .toList());
    }
}