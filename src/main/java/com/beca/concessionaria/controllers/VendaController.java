package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Venda;
import com.beca.concessionaria.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> adicionar(@RequestBody Venda venda) {
        Venda criar = vendaService.adicionar(venda);

        return ResponseEntity.created(null).body(criar);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Venda> atualizar(@RequestBody Venda venda, @PathVariable Long id) {
        Venda atualizar = vendaService.atualizar(venda, id);

        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Venda> obter(Long id) {
        Venda obter= vendaService.obter(id);

        return ResponseEntity.ok(obter);
    }

    @GetMapping("/{listar}")
    public ResponseEntity<List<Venda>> listar() {
        List<Venda> mostrar = vendaService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}
