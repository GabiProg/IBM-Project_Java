package com.terceiroexemplo.terceiroexemplo.repository;

import com.terceiroexemplo.terceiroexemplo.model.Candidato;
import com.terceiroexemplo.terceiroexemplo.model.exception.ResourceConflict;
import com.terceiroexemplo.terceiroexemplo.model.exception.ResourceNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CandidatoRepository {
    private ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
    private Integer ultimoId = 0;

    public int iniciarProcesso(String nome) {
        for (Candidato candidato : candidatos) {
            if(candidato.getNome().equals(nome)) {
                throw new ResourceConflict("Candidato já participa do processo.");
            }
        }
        Integer id = ++ultimoId;
        Candidato candidato = new Candidato (id, nome, "Recebido");
        candidatos.add(candidato);
        return id;
    }

    public void marcarEntrevista(int codCandidato) {
        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();
        if (candidato.isEmpty() || candidato == null){
            throw new ResourceNotFound("Candidato não encontrado.");
        } else {
            candidato.orElseThrow().setStatus("Qualificado");
        }
    }

    public void desqualificarCandidato(int codCandidato){
        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();
        if (candidato.isEmpty() || candidato == null){
            throw new ResourceNotFound("Candidato não encontrado.");
        }
        candidatos.removeIf(produto -> produto.getId() == codCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {
        for (Candidato candidato : candidatos) {
            if (candidato.getId() == codCandidato) {
                String status = candidato.getStatus();
                return status;
            }
        }
        throw new ResourceNotFound("Candidato não encontrado.");
    }

    public void aprovarCandidato(int codCandidato) {
        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();
        if (candidato.isEmpty() || candidato == null){
            throw new ResourceNotFound("Candidato não encontrado.");
        } else {
            candidato.orElseThrow().setStatus("Aprovado");
        }
    }

    public List<String> obterAprovados() {
        List<String> aprovados = new ArrayList<String>();
        for (Candidato candidato : candidatos) {
            if (candidato.getStatus().equals("Aprovado")){
                aprovados.add(candidato.getNome());
            }
        }
        return aprovados;
    }
}
