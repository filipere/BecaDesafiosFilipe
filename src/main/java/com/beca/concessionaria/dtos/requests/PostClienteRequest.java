package com.beca.concessionaria.dtos.requests;

import com.beca.concessionaria.dminios.Venda;

public class PostClienteRequest {

    private String nome;
    private Long idVenda;

    public PostClienteRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }
}
