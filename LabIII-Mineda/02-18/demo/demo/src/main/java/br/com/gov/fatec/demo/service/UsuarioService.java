package br.com.gov.fatec.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.gov.fatec.demo.entity.Usuario;
import br.com.gov.fatec.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
    }

    public Usuario novoUsuario (Usuario usuario) {
        if (usuario == null || 
            usuario.getNome() == null || 
            usuario.getSenha() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário inválido");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

}
