package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dtos.requests.PostClienteRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<PostClienteResponse> adicionar(
            @RequestBody @Valid PostClienteRequest postClienteRequest) {

        PostClienteResponse postClienteResponse = clienteService.adicionar(postClienteRequest);

        return ResponseEntity.created(null).body(postClienteResponse);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PostClienteResponse> atualizar(
            @RequestBody PostClienteRequest postClienteRequest, @PathVariable Long id) {

        PostClienteResponse atualizar = clienteService.atualizar(postClienteRequest, id);

        return ResponseEntity.ok(atualizar);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PostClienteResponse> obter(@PathVariable Long id) {
//        PostClienteResponse postClienteResponse = clienteService.obter(id);
//
//        return ResponseEntity.ok(postClienteResponse);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{mostrar}")
    public ResponseEntity<List<PostClienteResponse>> mostrar() {
        List<PostClienteResponse> mostrar = clienteService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}