package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Carro;
import com.beca.concessionaria.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Carro> adicionar(@RequestBody Carro carro) {
        Carro criar = carroService.adicionar(carro);

        return ResponseEntity.created(null).body(criar);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Carro> atualizar(@RequestBody Carro carro, @PathVariable Long id) {
        Carro atualizar = carroService.atualizar(carro, id);

        return ResponseEntity.ok(atualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obter(@PathVariable Long id) {
        Carro obter = carroService.obter(id);

        return ResponseEntity.ok(obter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        carroService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{mostrar}")
    public ResponseEntity<List<Carro>> mostrar() {
        List<Carro> mostrar = carroService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}