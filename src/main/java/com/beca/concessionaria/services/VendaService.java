package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public Venda adicionar(Venda venda) {
        Venda SalvandoVenda = vendaRepository.save(venda);

        return SalvandoVenda;
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