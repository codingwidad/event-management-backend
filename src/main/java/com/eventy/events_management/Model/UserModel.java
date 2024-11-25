package com.eventy.events_management.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import com.eventy.events_management.Model.Enums.Role;

@Entity
@Table(name = "users")

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "organizer")
    private Set<EventModel> events;

    @OneToMany(mappedBy = "attendee")
    private Set<RegistrationModel> registrations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null && password.length() < 8 ){
            throw new IllegalArgumentException("password must be at least 8 charachters long.");
        }
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<RegistrationModel> getRegistration() {
        return registrations;
    }

    public void setRegistration(Set<RegistrationModel> registrations) {
        this.registrations = registrations;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }
}
