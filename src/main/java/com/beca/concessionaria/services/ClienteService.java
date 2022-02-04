package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.GetClienteObterResponse;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.repositories.ClienteRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public PostClienteResponse adicionar(@NotNull PostClienteRequest postVendaRequest) {

        Cliente vendaObtida = clienteRepository.getById(postVendaRequest.getIdVenda());

        PostClienteResponse postClienteResponse = new PostClienteResponse();
        postClienteResponse.setIdVenda(vendaObtida.getId());

        return postClienteResponse;
    }

    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente clienteObter = clienteRepository.getById(id);
        cliente.setNome(cliente.getNome());

        clienteRepository.save(clienteObter);

        return clienteObter;
    }

    public GetClienteObterResponse obter(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();

        GetClienteObterResponse getClienteObterResponse = new GetClienteObterResponse();
        getClienteObterResponse.setId(cliente.getId());
        getClienteObterResponse.setNome(cliente.getNome());

        return getClienteObterResponse;
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @GetMapping("/clientes")
    public List<Cliente> mostrar() {
        List<Cliente> ListaClientes = clienteRepository.findAll();

        return ListaClientes;
    }
}
