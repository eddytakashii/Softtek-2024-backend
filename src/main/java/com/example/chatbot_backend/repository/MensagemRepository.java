package com.example.chatbot_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot_backend.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	//única query, responsável por buscar todas as mensagens do usuário
	@Query("SELECT m FROM Mensagem m JOIN m.conversa c WHERE c.usuario.idUsuario = :idUsuario")
    List<Mensagem> findByUsuarioId(@Param("idUsuario") Long idUsuario);
}
