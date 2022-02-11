package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dtos.requests.PostCarroRequest;
import com.beca.concessionaria.dtos.responses.PostCarroResponse;
import com.beca.concessionaria.services.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/carro")
public class CarroController {

    @Autowired
    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<PostCarroResponse> adicionar(
            @RequestBody @Valid PostCarroRequest postCarroRequest) {

        PostCarroResponse postCarroResponse = carroService.adicionar(postCarroRequest);

        return ResponseEntity.created(null).body(postCarroResponse);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<PostCarroResponse> atualizar(
            @RequestBody PostCarroRequest postCarroRequest, @PathVariable Long id) {

        PostCarroResponse atualizar = carroService.atualizar(postCarroRequest, id);

        return ResponseEntity.ok(atualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCarroResponse> obter(@PathVariable Long id) {
        PostCarroResponse postCarroResponse = carroService.obter(id);

        return ResponseEntity.ok(postCarroResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        carroService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{mostrar}")
    public ResponseEntity<List<PostCarroResponse>> mostrar() {
        List<PostCarroResponse> mostrar = carroService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}