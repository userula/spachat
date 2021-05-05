package com.example.spachat.controller;

import com.example.spachat.model.User;
import com.example.spachat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok("User successfully added");
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@RequestBody User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody User user) {
        try {
            userService.delete(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User successfully deleted");
    }
}
