package com.example.spachat.repository;

import com.example.spachat.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findParticipantByUserId(Long userId);
    List<Participant> findParticipantsByChatId(Long chatId);
}
