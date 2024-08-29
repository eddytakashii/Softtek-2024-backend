package com.example.chatbot_backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensagem;
    
    @ManyToOne
    @JoinColumn(name = "idConversa")
    private Conversa conversa;
    
    @Column(columnDefinition = "TEXT")
    private String textoEnviado;
    
    @Column(columnDefinition = "TEXT")
    private String textoRecebido;
    
    private LocalDateTime dataHora;

	public Long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}

	public String getTextoEnviado() {
		return textoEnviado;
	}

	public void setTextoEnviado(String textoEnviado) {
		this.textoEnviado = textoEnviado;
	}

	public String getTextoRecebido() {
		return textoRecebido;
	}

	public void setTextoRecebido(String textoRecebido) {
		this.textoRecebido = textoRecebido;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
