package com.terceiroexemplo.terceiroexemplo.service;

import com.terceiroexemplo.terceiroexemplo.model.Candidato;
import com.terceiroexemplo.terceiroexemplo.model.CandidatoDTO.CandidatoDTO;
import com.terceiroexemplo.terceiroexemplo.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public int iniciarProcesso(String nome) {
        return candidatoRepository.iniciarProcesso(nome);
    }

    public void marcarEntrevista(int codCandidato) {
        candidatoRepository.marcarEntrevista(codCandidato);
    }

    public void desqualificarCandidato(int codCandidato) {
        candidatoRepository.desqualificarCandidato(codCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {
        return candidatoRepository.verificarStatusCandidato(codCandidato);
    }

    public void aprovarCandidato(int codCandidato) {
        candidatoRepository.aprovarCandidato(codCandidato);
    }

    public List<String> obterAprovados() {
        return candidatoRepository.obterAprovados();
    }
}
