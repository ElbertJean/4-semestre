package br.com.guia.estudo.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Utilizamos o entity para mapear a entidade no banco de dados

@AllArgsConstructor     // construtor com todos os parâmetros
@NoArgsConstructor      // construtor sem parâmetros
@Entity
@Data
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @JsonView({View.UsuarioSimplificado.class, View.AnotacaoCompleta.class})
    private Long id;

    @Column(name = "usr_nome")
    @JsonView({View.UsuarioSimplificado.class, View.AnotacaoCompleta.class})
    private String nome;

    @Column(name = "usr_senha")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @OneToMany(mappedBy = "usuarioCriacao", fetch = FetchType.LAZY)
    @JsonView({View.UsuarioCompleto.class})
    private Set<Anotacao> anotacoes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "uau_usuario_autorizacao",
            joinColumns = { @JoinColumn(name = "usr_id")},
            inverseJoinColumns = { @JoinColumn(name = "aut_id")})
    @JsonView({View.UsuarioCompleto.class})
    private Set<Autorizacao> autorizacoes;
}
