package com.example.spachat.controller;

import com.example.spachat.model.Chat;
import com.example.spachat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(chatService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Chat chat) {
        chatService.add(chat);
        return ResponseEntity.ok("Chat successfully added");
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@RequestBody Chat chat) {
        try {
            chatService.update(chat);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(chat);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Chat chat) {
        try {
            chatService.delete(chat);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Chat successfully deleted");
    }
}
