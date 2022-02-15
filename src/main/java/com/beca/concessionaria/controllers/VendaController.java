package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dtos.requests.PostVendaRequest;
import com.beca.concessionaria.dtos.responses.PostClienteResponse;
import com.beca.concessionaria.dtos.responses.PostVendaResponse;
import com.beca.concessionaria.services.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/venda")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public ResponseEntity<PostVendaResponse> adicionar(
            @RequestBody @Valid PostVendaRequest postVendaRequest) {

        PostVendaResponse postVendaResponse = vendaService.adicionar(postVendaRequest);

        return ResponseEntity.created(null).body(postVendaResponse);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PostVendaResponse> atualizar(@RequestBody PostVendaRequest postVendaRequest, @PathVariable Long id) {
        PostVendaResponse atualizar = vendaService.atualizar(postVendaRequest, id);

        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<PostVendaResponse> obter(@PathVariable Long id) {
        PostVendaResponse postVendaResponse = vendaService.obter(id);

        return ResponseEntity.ok(postVendaResponse);
    }
    @GetMapping("/{listar}")
    public ResponseEntity<List<PostVendaResponse>> listar() {
        List<PostVendaResponse> mostrar = vendaService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}