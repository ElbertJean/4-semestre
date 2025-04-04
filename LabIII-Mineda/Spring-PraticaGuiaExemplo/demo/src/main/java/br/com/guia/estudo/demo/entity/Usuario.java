package br.com.guia.estudo.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Id   //defino qual é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // defino como o ID vai ser gerado
    @Column(name = "usr_id")    // defino o nome da coluna
    private Long id;    // defino o tipo da coluna

    @Column(name = "usr_nome", nullable = false)
    private String nome;

    @Column(name = "usr_senha", nullable = false)
    private String senha;
}
