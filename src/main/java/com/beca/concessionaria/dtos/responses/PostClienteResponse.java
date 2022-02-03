package com.beca.concessionaria.dtos.responses;

public class PostClienteResponse {

    private String nome;
    private Long idVenda;

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
