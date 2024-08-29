package com.example.chatbot_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot_backend.dto.LogResponseDTO;
import com.example.chatbot_backend.dto.RegistrarAcaoDTO;
import com.example.chatbot_backend.model.Log;
import com.example.chatbot_backend.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public LogResponseDTO registrarAcao(RegistrarAcaoDTO registrarAcaoDTO) {
        Log log = new Log();
        log.setIdUsuario(registrarAcaoDTO.getIdUsuario());
        log.setIdConversa(registrarAcaoDTO.getIdConversa());
        log.setAcao(registrarAcaoDTO.getAcao());
        log.setDataHora(LocalDateTime.now());
        log = logRepository.save(log);


        LogResponseDTO responseDTO = new LogResponseDTO();
        responseDTO.setIdLog(log.getIdLog());
        responseDTO.setIdUsuario(log.getIdUsuario());
        responseDTO.setIdConversa(log.getIdConversa());
        responseDTO.setAcao(log.getAcao());
        responseDTO.setDataHora(log.getDataHora());

        return responseDTO;
    }

    public List<Log> obterLogs() {
        return logRepository.findAll();
    }
}