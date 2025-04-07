package br.com.guia.estudo.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name= "ant_anotacao")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    @JsonView({View.UsuarioCompleto.class, View.AnotacaoCompleta.class})
    private Long id;

    @Column(name = "ant_texto")
    @JsonView({View.UsuarioCompleto.class, View.AnotacaoCompleta.class})
    private String texto;

    @Column(name = "ant_data_hora")
    @JsonView({View.UsuarioCompleto.class, View.AnotacaoCompleta.class})
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ant_usr_id")
    @JsonView({View.AnotacaoCompleta.class})
    private Usuario usuarioCriacao;
}
