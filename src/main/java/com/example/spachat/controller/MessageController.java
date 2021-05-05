package com.example.spachat.controller;

import com.example.spachat.model.Message;
import com.example.spachat.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(messageService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Message message) {
        messageService.add(message);
        return ResponseEntity.ok("Message successfully added");
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@RequestBody Message message) {
        messageService.update(message);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Message message) {
        messageService.delete(message);
        return ResponseEntity.ok("Message successfully deleted");
    }

    @GetMapping("/get-messages/{chatId}")
    public ResponseEntity<?> getMessagesByChatId(@PathVariable Long chatId) {
        return ResponseEntity.ok(messageService.findMessagesByChatId(chatId));
    }
}
