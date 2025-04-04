package br.com.guia.estudo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guia.estudo.demo.entity.Usuario;

// Repository é utilizado para manipular o banco de dados
// Ele é responsávle por fazer o CRUD

// O Repositório da entidade Usuario, consiste em uma interface que estende 
// JpaRepository (uma interface do Spring). 
// O Spring gera automaticamente todo o código necessário, mas, para isso, ele 
// precisa que você informa qual a classe de entidade associada (Usuario) e o 
// tipo do atributo que mapeia a coluna com restrição de chave primária (Long).

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByNomeAndSenha(String nome, String senha);
    
}
