package com.example.spachat.service;

import com.example.spachat.model.Message;
import com.example.spachat.repository.MessageRepository;
import com.example.spachat.service.interfaces.IMessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService {
    private final MessageRepository messageRepository;

    @Override
    public void add(Message o) {
        messageRepository.save(o);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public void update(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void delete(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public List<Message> findMessagesByChatId(Long chatId) {
        return messageRepository.findMessagesByChatId(chatId);
    }

}
