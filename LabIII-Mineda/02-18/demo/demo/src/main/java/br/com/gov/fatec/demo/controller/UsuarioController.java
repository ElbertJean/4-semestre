package br.com.gov.fatec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gov.fatec.demo.entity.Usuario;
import br.com.gov.fatec.demo.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @PostMapping
    public Usuario novoUsuario(Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(Long id) {
        return usuarioService.buscarPorId(id);
    }

}
