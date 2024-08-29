package com.example.chatbot_backend.dto;

import java.time.LocalDateTime;

public class ConversaResponseDTO {
    private Long idConversa;
    private LocalDateTime dataInicio;

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
}
