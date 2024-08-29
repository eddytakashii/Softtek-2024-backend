package com.example.chatbot_backend.dto;


public class MensagemResponseDTO {
    private Long idMensagem;
    private Long idUsuario;
    private Long idConversa;
    private String textoEnviado;
    private String textoRecebido;


    public Long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

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

