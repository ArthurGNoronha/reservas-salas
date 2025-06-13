package com.sala.sala.controller;

import com.sala.sala.model.Sala;
import com.sala.sala.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalaController {
    @Autowired
    private SalaService service;

    @GetMapping("/salas/front")
    public String salasPage() {
        return "salas";
    }

    @ResponseBody
    @GetMapping("/salas")
    public List<Sala> listarSalas() {
        return service.listar();
    }

    @PostMapping("/salas")
    @ResponseBody
    public Sala salvar(@RequestBody Sala sala) {
        return service.salvar(sala);
    }
}