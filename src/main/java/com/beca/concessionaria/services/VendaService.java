package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.repositories.ClienteRepository;
import com.beca.concessionaria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendaService vendaService;

    public PostClienteResponse adicionar(PostClienteRequest postClienteRequest) {

        Venda vendaObtida = vendaService.obter(postClienteRequest.getIdVenda());

        Cliente cliente = new Cliente();
        cliente.setNome(postClienteRequest.getNome());
        cliente.setVenda(vendaObtida);

        Cliente salvandoCliente = clienteRepository.save(cliente);

        PostClienteResponse postClienteResponse = new PostClienteResponse();
        postClienteResponse.setIdVenda(salvandoCliente.getId());

        return postClienteResponse;
    }

    public Venda atualizar(Venda venda, Long id) {
        Venda vendaObter = this.obter(id);
        venda.setId(venda.getId());

        vendaRepository.save(vendaObter);

        return vendaObter;
    }

    public Venda obter(Long id) {
        Venda venda = vendaRepository.findById(id).get();

        return venda;
    }

    public void excluir(Long id) {
        vendaRepository.deleteById(id);
    }
    @GetMapping("/vendas")
    public List<Venda> mostrar() {
        List<Venda> ListaVenda = vendaRepository.findAll();

        return ListaVenda;
    }
}