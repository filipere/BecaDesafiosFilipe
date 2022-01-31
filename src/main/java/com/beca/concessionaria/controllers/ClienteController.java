package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> adicionar(Cliente cliente) {
        Cliente criar = clienteService.adicionar(cliente);

        return ResponseEntity.created(null).body(criar);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {

        Cliente atualizar = clienteService.atualizar(cliente, id);

        return ResponseEntity.ok(atualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obter(@PathVariable Long id) {
        Cliente obter = clienteService.obter(id);

        return ResponseEntity.ok(obter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> mostrar() {
        List<Cliente> mostrar = clienteService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}