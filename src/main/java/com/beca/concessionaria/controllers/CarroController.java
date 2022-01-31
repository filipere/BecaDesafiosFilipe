package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Carro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/carro")
public class CarroController {

    @PostMapping
    public ResponseEntity<Carro> adicionarCarro(Carro carro) {
        System.out.println(carro);
        carro.setId(1L);

        System.out.println("Carro adicionado com sucesso!");

        return ResponseEntity.created(null).body(carro);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Carro> atualizar(@RequestBody Carro carro, @PathVariable Long id) {
        carro.setId(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping
    public ResponseEntity<Carro> obter(Long id) {
        Carro carro = new Carro();
        carro.setId(id);

        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<java.util.List<Carro>> mostrar() {
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

        return ResponseEntity.ok(List.of(carro1, carro2));
    }
}
