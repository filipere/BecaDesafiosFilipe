package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Cliente;
import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.GetClienteObterResponse;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
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
    public ResponseEntity<PostClienteResponse> adicionar (
            @RequestBody PostClienteRequest postClienteRequest) {

        PostClienteResponse postClienteResponse = clienteService.adicionar(postClienteRequest);

        return ResponseEntity.created(null).body(postClienteResponse);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {

        Cliente atualizar = clienteService.atualizar(cliente, id);

        return ResponseEntity.ok(atualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClienteObterResponse> obter(@PathVariable Long id) {
        GetClienteObterResponse getClienteObterResponse = clienteService.obter(id);

        return ResponseEntity.ok(getClienteObterResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{mostrar}")
    public ResponseEntity<List<Cliente>> mostrar() {
        List<Cliente> mostrar = clienteService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}