package com.example.chatbot_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot_backend.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}
