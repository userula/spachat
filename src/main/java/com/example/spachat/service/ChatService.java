package com.example.spachat.service;

import com.example.spachat.model.Chat;
import com.example.spachat.repository.ChatRepository;
import com.example.spachat.service.interfaces.IChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatService implements IChatService {
    private final ChatRepository chatRepository;

    @Override
    public void add(Chat o) {
        chatRepository.save(o);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }

    @Override
    public void update(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void delete(Chat chat) {
        chatRepository.delete(chat);
    }
}
