package com.beca.concessionaria.dminios;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String marca;
    @NonNull
    private String modelo;
    @NonNull
    private String cor;
    @NonNull
    private Integer ano;
}