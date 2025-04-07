package br.com.guia.estudo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guia.estudo.demo.entity.Usuario;
import br.com.guia.estudo.demo.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    @GetMapping(value = "/nome/{nome}")
    public Usuario getUsuarioByNome(@PathVariable String nome) {
        return usuarioService.getUsuarioByNome(nome);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }
}
