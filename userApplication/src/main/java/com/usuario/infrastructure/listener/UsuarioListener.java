package com.usuario.usuario.infrastructure.listener;

import com.response.dto.ValidateResponseDTO;
import com.request.dto.ValidateRequestDTO;
import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioListener {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RabbitListener(queues = "user-validate-queue")
    public ValidateResponseDTO validarUsuario(ValidateRequestDTO request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(request.getIdParaReserva());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return new ValidateResponseDTO(true, usuario.getNome());
        } else {
            return new ValidateResponseDTO(false, null);
        }
    }
}