package com.beca.concessionaria.services;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.repositories.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    public Carro adicionar(Carro carro) {
        System.out.println(carro);
        Carro SalvandoCarro = carroRepository.save(carro);

        return SalvandoCarro;
    }

    public Carro atualizar(Carro carro, Long id) {
        Carro carroObter = this.obter(id);
        carro.setMarca(carro.getMarca());

        carroRepository.save(carroObter);

        return carroObter;
    }

    public Carro obter(Long id) {
        Carro carro = carroRepository.findById(id).get();

        return carro;
    }

    public void excluir(Long id) {
        carroRepository.deleteById(id);
    }

    public List<Carro> mostrar() {
        List<Carro> ListaCarros = carroRepository.findAll();

        return ListaCarros;
    }
}