package com.example.chatbot_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot_backend.dto.AlterarSenhaDTO;
import com.example.chatbot_backend.dto.ConversaDTO;
import com.example.chatbot_backend.dto.UsuarioDTO;
import com.example.chatbot_backend.model.Usuario;
import com.example.chatbot_backend.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public Usuario criarConta(@RequestBody Usuario usuario) {
        return usuarioService.criarContaUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Usuario usuario) {
        Usuario loggedInUser = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        if (loggedInUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UsuarioDTO usuarioDTO = convertToDto(loggedInUser);
        return ResponseEntity.ok(usuarioDTO);
    }

    private UsuarioDTO convertToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        
        List<ConversaDTO> conversasDTO = usuario.getConversas().stream()
            .map(conversa -> {
                ConversaDTO conversaDTO = new ConversaDTO();
                conversaDTO.setIdConversa(conversa.getIdConversa());
                conversaDTO.setDataInicio(conversa.getDataInicio());
                conversaDTO.setDataFim(conversa.getDataFim());
                return conversaDTO;
            })
            .collect(Collectors.toList());
        dto.setConversas(conversasDTO);

        return dto;
    }

    @PutMapping("/alterarSenha")
    public Usuario alterarSenha(@RequestBody AlterarSenhaDTO alterarSenhaDTO) {
        return usuarioService.alterarSenha(alterarSenhaDTO.getId(), alterarSenhaDTO.getNovaSenha());
    }
}