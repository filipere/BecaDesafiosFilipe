package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Carro;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CarroService {

    public Carro adicionar(Carro carro) {
        System.out.println(carro);
        carro.setId(1L);

        System.out.println("Carro adicionado com sucesso!");

        return carro;
    }

    public Carro atualizar(Carro carro, Long id) {
        carro.setId(id);

        return carro;
    }

    public Carro obter(Long id) {
        Carro carro1 = new Carro();
        carro1.setId(id);

        return carro1;
    }

    public void excluir(Long id) {
        //
    }

    @GetMapping
    public List<Carro> mostrar() {
        Carro carro1 = new Carro();
        carro1.setId(1L);
        carro1.setMarca("Ferrari");
        carro1.setModelo("488 GTB");
        carro1.setCor("Vermelho");
        carro1.setAno(2015);

        Carro carro2 = new Carro();
        carro2.setId(2L);
        carro2.setMarca("Mercedes-Benz");
        carro2.setModelo("EQC");
        carro2.setCor("Branco");
        carro2.setAno(2020);

        return List.of(carro1, carro2);
    }
}