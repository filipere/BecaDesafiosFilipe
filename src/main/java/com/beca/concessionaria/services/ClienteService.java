package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public Cliente adicionar(Cliente cliente) {
        System.out.println(cliente);
        cliente.setId(1L);

        System.out.println("Cliente adicionado com sucesso!");

        return cliente;
    }

    public Cliente atualizar(Cliente cliente, Long id) {
        cliente.setId(id);

        return cliente;
    }

    public Cliente obter(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);

        return cliente;
    }

    public void excluir(Long id) {
        //
    }

    public List<Cliente> mostrar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Ana Luiza");
        cliente1.setEmail("analu@email.com");
        cliente1.setTelefone(88-95555-5555);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("JoÃ£o Pedro");
        cliente2.setEmail("jpedro@email.com");
        cliente2.setTelefone(99-91111-1111);

        return List.of(cliente1, cliente2);
    }
}
