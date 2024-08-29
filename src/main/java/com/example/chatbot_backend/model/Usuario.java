package com.example.chatbot_backend.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nome;
    
    private String email;
    
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private Set<Conversa> conversas;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Conversa> getConversas() {
		return conversas;
	}

	public void setConversas(Set<Conversa> conversas) {
		this.conversas = conversas;
	}

}

