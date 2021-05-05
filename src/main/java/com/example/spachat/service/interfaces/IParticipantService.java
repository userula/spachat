package com.example.spachat.service.interfaces;

import com.example.spachat.model.Chat;
import com.example.spachat.model.Participant;
import com.example.spachat.model.User;

import java.util.List;

public interface IParticipantService extends IService<Participant> {
    List<Chat> getChatsByUserId(Long userId);
    List<User> getUsersByChatId(Long chatId);
}
