package com.beca.concessionaria.dminios;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private String email;
    @NonNull
    private Integer telefone;
    @OneToOne
    private Venda venda;

    public Cliente() {

    }
}