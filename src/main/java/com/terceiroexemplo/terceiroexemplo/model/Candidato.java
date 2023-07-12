package com.terceiroexemplo.terceiroexemplo.model;

public class Candidato {
    private Integer id;
    private String nome;
    private String status;


    public Candidato(Integer id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}