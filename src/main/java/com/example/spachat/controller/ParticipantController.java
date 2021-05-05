package com.example.spachat.controller;

import com.example.spachat.model.Participant;
import com.example.spachat.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(participantService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Participant participant) {
        participantService.add(participant);
        return ResponseEntity.ok("Participant successfully added");
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@RequestBody Participant participant) {
        participantService.update(participant);
        return ResponseEntity.ok(participant);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Participant participant) {
        participantService.delete(participant);
        return ResponseEntity.ok("Participant successfully deleted");
    }

    @GetMapping("/chat/{chatId}")
    public ResponseEntity<?> getUsersByChatId(@PathVariable Long chatId){
        return ResponseEntity.ok(participantService.getUsersByChatId(chatId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getChatsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(participantService.getChatsByUserId(userId));
    }
}
