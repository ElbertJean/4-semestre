package com.guiaprova.guiaprova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.guiaprova.guiaprova.entity.Trabalho;
import com.guiaprova.guiaprova.service.TrabalhoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/trabalho")
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<Trabalho> getAllWorks() {
        return trabalhoService.getAllWorks();
    }

    @PostMapping
    public Trabalho registerWork(@RequestBody Trabalho trabalho) {
        return trabalhoService.registerWork(trabalho);
    }

    @GetMapping("/buscar")
    public List<Trabalho> searchByTitleAndGrade(@RequestParam String keyword, @RequestParam Integer grade) {
        return trabalhoService.searchByTitleAndGrade(keyword, grade);
    }
}
