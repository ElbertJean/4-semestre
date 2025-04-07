package br.com.guia.estudo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.guia.estudo.demo.entity.Anotacao;
import br.com.guia.estudo.demo.entity.View;
import br.com.guia.estudo.demo.repository.AnotacaoRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/anotacao")
public class AnotacaoController {
    
    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @GetMapping
    @JsonView(View.AnotacaoCompleta.class)
    public List<Anotacao> buscarTodas() {
        return anotacaoRepository.findAll();
    }

}
