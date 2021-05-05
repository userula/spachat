package com.example.spachat.repository;

import com.example.spachat.model.Chat;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
