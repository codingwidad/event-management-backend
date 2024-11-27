package com.eventy.events_management.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventy.events_management.Model.UserModel;
import com.eventy.events_management.Model.Enums.Role;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findById(String id);
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findByRole(Role role);
    List<UserModel> findByCreatedAtAfter(LocalDateTime createdAt);
    List<UserModel> findByCreatedAtBetween(LocalDateTime start, LocalDateTime after);
    List<UserModel> findByNameContainingIgnoreCase(String subString);
    Long countByRole(Role role);
}
