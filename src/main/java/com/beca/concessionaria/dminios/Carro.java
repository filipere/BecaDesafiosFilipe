package com.beca.concessionaria.dminios;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String marca;
    @NonNull
    private String cor;

    private Long ano;

    public Carro() {

    }
}