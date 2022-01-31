package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dminios.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/cliente")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(Cliente cliente) {
        System.out.println(cliente);
        cliente.setId(1L);

        System.out.println("Carro adicionado com sucesso!");

        return ResponseEntity.created(null).body(cliente);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        cliente.setId(id);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> mostrar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Ana Luiza");
        cliente1.setEmail("analu@email.com");
        cliente1.setTelefone(88-95555-5555);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("João Pedro");
        cliente2.setEmail("jpedro@email.com");
        cliente2.setTelefone(99-91111-1111);

        return ResponseEntity.ok(List.of(cliente1, cliente2));
    }
}