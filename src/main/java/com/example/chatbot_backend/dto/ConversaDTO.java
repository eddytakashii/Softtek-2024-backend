package com.example.chatbot_backend.dto;

import java.time.LocalDateTime;

public class ConversaDTO {
    private Long idConversa;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    // Getters e Setters
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

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}