package com.example.chatbot_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot_backend.dto.MensagensPorUsuarioDTO;
import com.example.chatbot_backend.dto.RegistrarAcaoDTO;
import com.example.chatbot_backend.model.Conversa;
import com.example.chatbot_backend.model.Mensagem;
import com.example.chatbot_backend.model.Usuario;
import com.example.chatbot_backend.repository.ConversaRepository;
import com.example.chatbot_backend.repository.MensagemRepository;
import com.example.chatbot_backend.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversaService {
    @Autowired
    private ConversaRepository conversaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private LogService logService;

    public Conversa iniciarConversa(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            Conversa conversa = new Conversa();
            conversa.setUsuario(usuario);
            conversa.setDataInicio(LocalDateTime.now());
            conversa = conversaRepository.save(conversa);

            
            RegistrarAcaoDTO registrarAcaoDTO = new RegistrarAcaoDTO();
            registrarAcaoDTO.setIdUsuario(idUsuario);
            registrarAcaoDTO.setIdConversa(conversa.getIdConversa());
            registrarAcaoDTO.setAcao("Iniciou a conversa");
            logService.registrarAcao(registrarAcaoDTO);

            return conversa;
        }
        return null;
    }

    public Conversa finalizarConversa(Long idConversa) {
        Conversa conversa = conversaRepository.findById(idConversa).orElse(null);
        if (conversa != null) {
            conversa.setDataFim(LocalDateTime.now());
            conversa = conversaRepository.save(conversa);

            
            RegistrarAcaoDTO registrarAcaoDTO = new RegistrarAcaoDTO();
            registrarAcaoDTO.setIdUsuario(conversa.getUsuario().getIdUsuario());
            registrarAcaoDTO.setIdConversa(conversa.getIdConversa());
            registrarAcaoDTO.setAcao("Finalizou a conversa");
            logService.registrarAcao(registrarAcaoDTO);

            return conversa;
        }
        return null;
    }
    
    public MensagensPorUsuarioDTO listarMensagensPorUsuario(Long idUsuario) {
        List<Conversa> conversas = conversaRepository.findByUsuarioId(idUsuario);
        List<Mensagem> mensagens = conversas.stream()
                .flatMap(conversa -> mensagemRepository.findByUsuarioId(conversa.getIdConversa()).stream())
                .collect(Collectors.toList());

        MensagensPorUsuarioDTO resposta = new MensagensPorUsuarioDTO();
        resposta.setIdUsuario(idUsuario);
        resposta.setNome(usuarioRepository.findById(idUsuario).map(usuario -> usuario.getNome()).orElse("Desconhecido"));

        List<MensagensPorUsuarioDTO.MensagemDTO> mensagensDTO = mensagens.stream()
                .map(mensagem -> {
                    MensagensPorUsuarioDTO.MensagemDTO mensagemDTO = new MensagensPorUsuarioDTO.MensagemDTO();
                    mensagemDTO.setIdMensagem(mensagem.getIdMensagem());
                    mensagemDTO.setTextoEnviado(mensagem.getTextoEnviado());
                    mensagemDTO.setTextoRecebido(mensagem.getTextoRecebido());
                    mensagemDTO.setDataHora(mensagem.getDataHora().toString());
                    return mensagemDTO;
                })
                .collect(Collectors.toList());

        resposta.setMensagens(mensagensDTO);

        return resposta;
    }
}

