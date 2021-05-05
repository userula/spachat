package com.example.spachat.service.interfaces;

import com.example.spachat.model.Message;

import java.util.List;

public interface IMessageService extends IService<Message> {
    List<Message> findMessagesByChatId(Long chatId);
}
