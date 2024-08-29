package com.example.chatbot_backend.dto;


public class EnviarMensagemDTO {
    private Long idConversa;
    private String textoEnviado;
    private String textoRecebido;

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
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

    
}

