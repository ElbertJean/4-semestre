package br.com.guia.estudo.demo.repository;

import java.util.Optional;

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

    boolean existsByNome(String nome);
    
    Optional<Usuario> findByNomeIgnoreCase(String nome);

}


// // Verifica se existe um usuário com o nome exato
//     boolean existsByNome(String nome);

//     // Verifica se existe um usuário com o nome, ignorando maiúsculas/minúsculas
//     boolean existsByNomeIgnoreCase(String nome);

//     // Busca um usuário pelo nome (exato)
//     Optional<Usuario> findByNome(String nome);

//     // Busca um usuário pelo nome, ignorando maiúsculas/minúsculas
//     Optional<Usuario> findByNomeIgnoreCase(String nome);

//     // Busca um usuário pelo e-mail
//     Optional<Usuario> findByEmail(String email);

//     // Busca um usuário pelo e-mail e senha (ex: login)
//     Optional<Usuario> findByEmailAndSenha(String email, String senha);

//     // Busca usuários que tenham o nome ou o e-mail informados
//     List<Usuario> findByNomeOrEmail(String nome, String email);

//     // Busca usuários cujo nome contenha um determinado trecho
//     List<Usuario> findByNomeContaining(String nome);

//     // Igual ao anterior, mas ignorando maiúsculas/minúsculas
//     List<Usuario> findByNomeContainingIgnoreCase(String nome);

//     // Busca usuários cujo nome começa com determinado prefixo
//     List<Usuario> findByNomeStartingWith(String prefixo);

//     // Busca usuários cujo nome termina com determinado sufixo
//     List<Usuario> findByNomeEndingWith(String sufixo);

//     // Busca usuários com idade maior que o valor especificado
//     List<Usuario> findByIdadeGreaterThan(int idade);

//     // Busca usuários com idade menor ou igual ao valor especificado
//     List<Usuario> findByIdadeLessThanEqual(int idade);

//     // Busca usuários com nome e ordena por idade crescente
//     List<Usuario> findByNomeOrderByIdadeAsc();

//     // Busca usuários com nome e ordena por idade decrescente
//     List<Usuario> findByNomeOrderByIdadeDesc();

//     // Busca os 3 usuários mais velhos
//     List<Usuario> findTop3ByOrderByIdadeDesc();

//     // Busca o usuário mais novo
//     Optional<Usuario> findFirstByOrderByIdadeAsc();

//     // Combinação: busca usuários cujo nome contenha algo, ignorando maiúsculas, e ordena por idade decrescente
//     List<Usuario> findByNomeContainingIgnoreCaseOrderByIdadeDesc(String nome);

// ****************************************************************************************************************

// @Query("select u from Usuario u where u.nome = ?1")
// public Optional<Usuario> buscarPorNome(String nomeUsuario);

// public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

// @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
// public Optional<Usuario> buscarPorNomeESenha(String nome, String senha);

// public List<Usuario> findByNomeContains(String nome);

// @Query("select u from Usuario u where u.nome like %?1%")
// public List<Usuario> buscarPorNomeContem(String nome);

// public List<Usuario> findByAnotacoesTextoContains(String texto);

// @Query("select u from Usuario u join u.anotacoes a where a.texto like %?1%")
// public List<Usuario> buscarPorTextoEmAnotacao(String texto);