package com.example.chatbot_backend.dto;


import java.util.List;

public class MensagensPorUsuarioDTO {
    private Long idUsuario;
    private String nome;
    private List<MensagemDTO> mensagens;

   

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

    public List<MensagemDTO> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<MensagemDTO> mensagens) {
        this.mensagens = mensagens;
    }

    public static class MensagemDTO {
        private Long idMensagem;
        private String dataHora;
        private String textoEnviado;
        private String textoRecebido;

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

		public Long getIdMensagem() {
            return idMensagem;
        }

        public void setIdMensagem(Long idMensagem) {
            this.idMensagem = idMensagem;
        }


        public String getDataHora() {
            return dataHora;
        }

        public void setDataHora(String dataHora) {
            this.dataHora = dataHora;
        }
    }
}

