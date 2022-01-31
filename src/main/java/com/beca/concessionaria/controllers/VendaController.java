package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Venda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/venda")
public class VendaController {

    @PostMapping
    public ResponseEntity<Venda> adicionar(Venda venda) {
        System.out.println(venda);
        venda.setId(1L);

        System.out.println("Nova venda!");

        return ResponseEntity.created(null).body(venda);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Venda> atualizar(@RequestBody Venda venda, @PathVariable Long id) {
        venda.setId(id);

        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<Venda> obter(@PathVariable Long id) {
        Venda venda = new Venda();
        venda.setId(id);

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Venda>> mostrar() {
        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setPreco(500.000);
        venda1.setQuantidade(1);

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setPreco(300.000);
        venda2.setQuantidade(1);

        return ResponseEntity.ok(List.of(venda1, venda2));
    }
}
