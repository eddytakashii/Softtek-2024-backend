package com.example.chatbot_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot_backend.dto.MensagemResponseDTO;
import com.example.chatbot_backend.dto.RegistrarAcaoDTO;
import com.example.chatbot_backend.model.Conversa;
import com.example.chatbot_backend.model.Mensagem;
import com.example.chatbot_backend.repository.ConversaRepository;
import com.example.chatbot_backend.repository.MensagemRepository;

import java.time.LocalDateTime;

@Service
public class MensagemService {
    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private ConversaRepository conversaRepository;

    @Autowired
    private LogService logService;

    public MensagemResponseDTO enviarMensagem(Long idConversa, String textoEnviado, String textoRecebido) {
        Conversa conversa = conversaRepository.findById(idConversa).orElse(null);
        if (conversa != null) {
            Mensagem mensagem = new Mensagem();
            mensagem.setConversa(conversa);
            mensagem.setTextoEnviado(textoEnviado);
            mensagem.setTextoRecebido(textoRecebido);
            mensagem.setDataHora(LocalDateTime.now());
            mensagem = mensagemRepository.save(mensagem);
           
            RegistrarAcaoDTO registrarAcaoDTO = new RegistrarAcaoDTO();
            registrarAcaoDTO.setIdUsuario(conversa.getUsuario().getIdUsuario());
            registrarAcaoDTO.setIdConversa(conversa.getIdConversa());
            registrarAcaoDTO.setAcao("Enviou uma mensagem: " + textoEnviado);
            logService.registrarAcao(registrarAcaoDTO);


            MensagemResponseDTO resposta = new MensagemResponseDTO();
            resposta.setIdMensagem(mensagem.getIdMensagem());
            resposta.setIdUsuario(conversa.getUsuario().getIdUsuario());
            resposta.setIdConversa(conversa.getIdConversa());
            resposta.setTextoEnviado(textoEnviado);
            resposta.setTextoRecebido(mensagem.getTextoRecebido());

            return resposta;
        }
        return null;
    }
}
