package com.reservasala.service;

import com.request.dto.ValidateRequestDTO;
import com.response.dto.ValidateResponseDTO;
import com.reservasala.model.Reserva;
import com.reservasala.repository.ReservaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        ValidateRequestDTO usuarioRequest = new ValidateRequestDTO(
            reserva.getUsuarioId(),
            "Microserviço de Reserva",
            LocalDateTime.now()
        );
        ValidateResponseDTO usuarioResponse = (ValidateResponseDTO) rabbitTemplate.convertSendAndReceive(
                "user-validate-queue", usuarioRequest);

        ValidateRequestDTO salaRequest = new ValidateRequestDTO(
            reserva.getSalaId(),
            "Microserviço de Reserva",
            LocalDateTime.now()
        );
        ValidateResponseDTO salaResponse = (ValidateResponseDTO) rabbitTemplate.convertSendAndReceive(
                "sala-validate-queue", salaRequest);

        boolean usuarioExiste = usuarioResponse != null && usuarioResponse.isExiste();
        boolean salaExiste = salaResponse != null && salaResponse.isExiste();
        
        if (!usuarioExiste) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        if (!salaExiste) {
            throw new RuntimeException("Sala não encontrada!");
        }

        reserva.setNomeUsuario(usuarioResponse.getNome());
        reserva.setNomeSala(salaResponse.getNome());

        return repository.save(reserva);
    }
}