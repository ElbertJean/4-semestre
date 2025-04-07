package br.com.guia.estudo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guia.estudo.demo.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

}
