package com.example.chatbot_backend.dto;

import java.time.LocalDateTime;

public class ConversaFinalizadaResponseDTO {
    private Long idConversa;
    private LocalDateTime dataFim;

    
    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
