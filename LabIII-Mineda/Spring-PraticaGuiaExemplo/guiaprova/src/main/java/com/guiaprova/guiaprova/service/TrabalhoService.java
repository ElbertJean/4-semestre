package com.guiaprova.guiaprova.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.guiaprova.guiaprova.entity.Trabalho;
import com.guiaprova.guiaprova.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Trabalho registerWork(Trabalho trabalho) {
        if (!StringUtils.hasText(trabalho.getTitulo()) || !StringUtils.hasText(trabalho.getGrupo())) {
            throw new IllegalArgumentException("Título e grupo são obrigatórios.");
        }

        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(Timestamp.from(Instant.now()));
        }

        return trabalhoRepository.save(trabalho);
    }

    public List<Trabalho> getAllWorks() {
        return trabalhoRepository.findAll();
    }

    public List<Trabalho> searchByTitleAndGrade(String keyword, Integer grade) {
        return trabalhoRepository.findByTitleAndNote(keyword, grade);
    }
}
