package com.example.chatbot_backend.dto;

import java.util.List;

public class UsuarioDTO {
    private Long idUsuario;
    private String nome;
    private String email;
    private List<ConversaDTO> conversas;

    // Getters e Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ConversaDTO> getConversas() {
        return conversas;
    }

    public void setConversas(List<ConversaDTO> conversas) {
        this.conversas = conversas;
    }
}