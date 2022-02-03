package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    public PostClienteResponse adicionar(PostClienteRequest postVendaRequest) {

        Cliente vendaObtida = clienteService.obter(postVendaRequest.getIdVenda());

        PostClienteResponse postClienteResponse = new PostClienteResponse();
        postClienteResponse.setIdVenda(vendaObtida.getId());

        return postClienteResponse;
    }

    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente clienteObter = this.obter(id);
        cliente.setNome(cliente.getNome());

        clienteRepository.save(clienteObter);

        return clienteObter;
    }

    public Cliente obter(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();

        return cliente;
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
