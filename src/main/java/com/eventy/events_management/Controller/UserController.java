package com.eventy.events_management.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventy.events_management.Model.UserModel;
import com.eventy.events_management.Model.Enums.Role;
import com.eventy.events_management.Service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
        Optional<UserModel> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        Optional<UserModel> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserModel>> getUserByRole(@PathVariable Role role) {
        List<UserModel> users = userService.getUserByRole(role);
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/created-after")
    public ResponseEntity<List<UserModel>> getUserCreatedAtAfter(@RequestParam String createdAt) {
        try {
            LocalDateTime date = LocalDateTime.parse(createdAt);
            List<UserModel> users = userService.getUserCreatedAtAfter(date);
            if (users.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/created-between")
    public ResponseEntity<List<UserModel>> getUserCreatedAtBetween(
            @RequestParam String start,
            @RequestParam String end) {
        try {
            LocalDateTime startDateTime = LocalDateTime.parse(start);
            LocalDateTime endDateTime = LocalDateTime.parse(end);
            List<UserModel> users = userService.getUserByCreatedAtBetween(startDateTime, endDateTime);
            if (users.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
