package br.com.guia.estudo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.guia.estudo.demo.entity.Usuario;
import br.com.guia.estudo.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário nao encontrado");
    }
    
    public Usuario createUsuario(Usuario usuario) {
    if (usuario.getNome() == null || usuario.getNome().trim().isEmpty() ||
        usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome e senha são obrigatórios");
    }

    if (!usuarioRepository.existsByNomeAndSenha(usuario.getNome(), usuario.getSenha())) {
        return usuarioRepository.save(usuario);
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");
}
}
