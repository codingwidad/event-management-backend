package com.eventy.events_management.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventy.events_management.Model.UserModel;
import com.eventy.events_management.Model.Enums.Role;
import com.eventy.events_management.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserModel> getUserById(String id) {
        return userRepository.findByEmail(id);
    }

    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<UserModel> getUserByRole(Role role) {
        return userRepository.findByRole(role);
    }
    public List<UserModel> getUserCreatedAtAfter(LocalDateTime createdAt) {
        return userRepository.findByCreatedAtAfter(createdAt);
    }
    public List<UserModel> getUserByNameIgnoreCase(String subString) {
        return userRepository.findByNameContainingIgnoreCase(subString);
    }
    public List<UserModel> getUserByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return userRepository.findByCreatedAtBetween(start, end);
    }
    public Long getCountByRole(Role role) {
        return userRepository.countByRole(role);
    }
}
