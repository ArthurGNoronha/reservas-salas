package com.reservasala.controller;

import com.reservasala.model.Reserva;
import com.reservasala.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservasController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas/front")
    public String reservasPage() {
        return "reservas";
    }

    @ResponseBody
    @GetMapping("/reservas")
    public List<Reserva> listarReservas() {
        return reservaService.listar();
    }

    @PostMapping("/reservas")
    @ResponseBody
    public Reserva salvar(@RequestBody Reserva reserva) {
        return reservaService.salvar(reserva);
    }
}