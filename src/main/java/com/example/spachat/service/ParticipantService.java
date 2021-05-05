package com.example.spachat.service;

import com.example.spachat.model.Chat;
import com.example.spachat.model.Participant;
import com.example.spachat.model.User;
import com.example.spachat.repository.ChatRepository;
import com.example.spachat.repository.ParticipantRepository;
import com.example.spachat.repository.UserRepository;
import com.example.spachat.service.interfaces.IParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ParticipantService implements IParticipantService {
    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    @Override
    public void add(Participant o) {
        participantRepository.save(o);
    }

    @Override
    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public void update(Participant participant) {
        participantRepository.save(participant);
    }

    @Override
    public void delete(Participant participant) {
        participantRepository.delete(participant);
    }

    @Override
    public List<User> getUsersByChatId(Long chatId) {
        List<Participant> participants = participantRepository.findParticipantsByChatId(chatId);
        return participants.stream()
                .map(participant -> userRepository.findById(participant.getUserId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public List<Chat> getChatsByUserId(Long userId) {
        List<Participant> participants = participantRepository.findParticipantByUserId(userId);
        return participants.stream()
                .map(participant -> chatRepository.findById(participant.getChatId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
