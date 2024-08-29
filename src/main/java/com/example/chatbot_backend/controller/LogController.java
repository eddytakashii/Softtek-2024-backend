package com.example.chatbot_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot_backend.dto.LogResponseDTO;
import com.example.chatbot_backend.dto.RegistrarAcaoDTO;
import com.example.chatbot_backend.model.Log;
import com.example.chatbot_backend.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/registrar")
    public LogResponseDTO registrarAcao(@RequestBody RegistrarAcaoDTO registrarAcaoDTO) {
        return logService.registrarAcao(registrarAcaoDTO);
    }
    
    @GetMapping("/obter")
    public List<Log> obterLogs() {
        return logService.obterLogs();
    }
}

