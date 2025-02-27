package br.com.gov.fatec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gov.fatec.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
