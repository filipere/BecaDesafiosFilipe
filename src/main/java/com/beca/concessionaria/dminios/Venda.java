package com.beca.concessionaria.dminios;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private Double preco;
    @NonNull
    private Integer quantidade;
    @OneToOne
    private Carro Carro;
}