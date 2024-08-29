package com.example.chatbot_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot_backend.dto.ConversaFinalizadaResponseDTO;
import com.example.chatbot_backend.dto.ConversaResponseDTO;
import com.example.chatbot_backend.dto.EnviarMensagemDTO;
import com.example.chatbot_backend.dto.FinalizarConversaDTO;
import com.example.chatbot_backend.dto.IniciarConversaDTO;
import com.example.chatbot_backend.dto.MensagemResponseDTO;
import com.example.chatbot_backend.dto.MensagensPorUsuarioDTO;
import com.example.chatbot_backend.model.Conversa;
import com.example.chatbot_backend.service.ConversaService;
import com.example.chatbot_backend.service.MensagemService;

@RestController
@RequestMapping("/conversa")
public class ConversaController {
    @Autowired
    private ConversaService conversaService;

    @Autowired
    private MensagemService mensagemService;

    @PostMapping("/iniciar")
    public ConversaResponseDTO iniciarConversa(@RequestBody IniciarConversaDTO iniciarConversaDTO) {
        Conversa conversa = conversaService.iniciarConversa(iniciarConversaDTO.getIdUsuario());
        ConversaResponseDTO responseDTO = new ConversaResponseDTO();
        if (conversa != null) {
            responseDTO.setIdConversa(conversa.getIdConversa());
            responseDTO.setDataInicio(conversa.getDataInicio());
        }
        return responseDTO;
    }

    @PostMapping("/enviarMensagem")
    public MensagemResponseDTO enviarMensagem(@RequestBody EnviarMensagemDTO enviarMensagemDTO) {
        return mensagemService.enviarMensagem
        		(enviarMensagemDTO.getIdConversa(), enviarMensagemDTO.getTextoEnviado(),enviarMensagemDTO.getTextoRecebido());
    }

    @PutMapping("/finalizar")
    public ConversaFinalizadaResponseDTO finalizarConversa(@RequestBody FinalizarConversaDTO finalizarConversaDTO) {
        Conversa conversa = conversaService.finalizarConversa(finalizarConversaDTO.getIdConversa());
        ConversaFinalizadaResponseDTO responseDTO = new ConversaFinalizadaResponseDTO();
        if (conversa != null) {
            responseDTO.setIdConversa(conversa.getIdConversa());
            responseDTO.setDataFim(conversa.getDataFim());
        }
        return responseDTO;
    }
    
    @GetMapping("/mensagensPorUsuario/{idUsuario}")
    public MensagensPorUsuarioDTO listarMensagensPorUsuario(@PathVariable Long idUsuario) {
        return conversaService.listarMensagensPorUsuario(idUsuario);
    }
}
