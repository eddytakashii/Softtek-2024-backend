package com.example.chatbot_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot_backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
