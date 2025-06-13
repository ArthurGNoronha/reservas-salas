package com.reservasala.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private long salaId;
    private long usuarioId;
    private String nomeUsuario;
    private String nomeSala;

    public void setSalaId(long salaId) {
        this.salaId = salaId;
    }
    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }
}