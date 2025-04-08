package com.guiaprova.guiaprova.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "tra_trabalho")
public class Trabalho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "tra_id")
    private Long id;

    @Column (name = "tra_titulo" , nullable = false, unique = true, length = 100)
    private String titulo;

    @Column (name = "tra_data_hora_entrega" , nullable = false)
    private Timestamp dataHoraEntrega;

    @Column (name = "tra_descricao", length = 200)
    private String descricao;

    @Column (name = "tra_grupo" , nullable = false, length = 20)
    private String grupo;

    @Column (name = "tra_nota")
    private Integer nota;

    @Column (name = "tra_justificativa", length = 100)
    private String justificativa;
}
