package com.request.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ValidateRequestDTO {
    private String messageId;
    private String origem;
    private Long idParaReserva;
    private LocalDateTime dataHora;

    public ValidateRequestDTO(Long idParaReserva, String origem, LocalDateTime dataHora) {
        this.messageId = UUID.randomUUID().toString();
        this.idParaReserva = idParaReserva;
        this.origem = origem;
        this.dataHora = dataHora;
    }

    public String getMessageId() { return messageId; }
    public String getOrigem() { return origem; }
    public Long getIdParaReserva() { return idParaReserva; }
    public void setidParaReserva(Long idParaReserva) { this.idParaReserva = idParaReserva; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}