package com.example.chatbot_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot_backend.model.Conversa;

public interface ConversaRepository extends JpaRepository<Conversa, Long> {
	 @Query(value = "SELECT * FROM conversa WHERE id_usuario = :idUsuario", nativeQuery = true)
	    List<Conversa> findByUsuarioId(@Param("idUsuario") Long idUsuario);
}
