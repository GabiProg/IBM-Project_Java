package com.terceiroexemplo.terceiroexemplo.controller;

import com.terceiroexemplo.terceiroexemplo.model.CandidatoDTO.CandidatoDTO;
import com.terceiroexemplo.terceiroexemplo.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hiring")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/start")
    public int iniciarProcesso(@RequestBody String nome) {
        return candidatoService.iniciarProcesso(nome);
    }

    @PostMapping("/schedule")
    public void marcarEntrevista(@RequestBody CandidatoDTO codCandidato) {
        candidatoService.marcarEntrevista(codCandidato.id());
    }

    @PostMapping("/disqualify")
    public void desqualificarCandidato(@RequestBody CandidatoDTO codCandidato) {
        candidatoService.desqualificarCandidato(codCandidato.id());
    }

    @GetMapping("/status/candidate/{codCandidato}")
    public String verificarStatusCandidato(@PathVariable int codCandidato) {
        return candidatoService.verificarStatusCandidato(codCandidato);
    }

    @PostMapping("/approve")
    public void aprovarCandidato(@RequestBody CandidatoDTO codCandidato) {
        candidatoService.aprovarCandidato(codCandidato.id());
    }

    @GetMapping("/approved")
    public List<String> obterAprovados() {
        return candidatoService.obterAprovados();
    }
}
