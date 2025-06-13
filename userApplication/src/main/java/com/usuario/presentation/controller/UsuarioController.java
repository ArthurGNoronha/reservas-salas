package com.usuario.usuario.controller;

import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios/front")
    public String usuariosPage() {
        return "usuarios";
    }

    @ResponseBody
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return service.listar();
    }

    @PostMapping("/usuarios")
    @ResponseBody
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }
}