package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Venda;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VendaService {

    public Venda adicionar(Venda venda) {
        System.out.println(venda);
        venda.setId(1L);

        System.out.println("Venda adicionada com sucesso!");

        return venda;
    }

    public Venda atualizar(Venda venda, Long id) {
        venda.setId(id);

        return venda;
    }

    public Venda obter(Long id) {
        Venda venda = new Venda();
        venda.setId(id);

        return venda;
    }

    public void excluir(Long id) {
        //
    }
    @GetMapping(path= "/vendas")
    public List<Venda> mostrar() {
        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setPreco(500.000);
        venda1.setQuantidade(1);

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setPreco(300.000);
        venda2.setQuantidade(1);

        return List.of(venda1, venda2);
    }
}