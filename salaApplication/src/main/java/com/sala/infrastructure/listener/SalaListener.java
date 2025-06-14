package com.sala.sala.infrastructure.listener;

import com.response.dto.ValidateResponseDTO;
import com.request.dto.ValidateRequestDTO;
import com.sala.sala.model.Sala;
import com.sala.sala.repository.SalaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaListener {

    @Autowired
    private SalaRepository salaRepository;

    @RabbitListener(queues = "sala-validate-queue")
    public ValidateResponseDTO validarSala(ValidateRequestDTO request) {
        Optional<Sala> salaOpt = salaRepository.findById(request.getIdParaReserva());
        if (salaOpt.isPresent()) {
            Sala sala = salaOpt.get();
            return new ValidateResponseDTO(true, sala.getNome());
        } else {
            return new ValidateResponseDTO(false, null);
        }
    }
}