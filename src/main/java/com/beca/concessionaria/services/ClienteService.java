package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente) {
        Cliente SalvandoCliente = clienteRepository.save(cliente);

        return SalvandoCliente ;
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
