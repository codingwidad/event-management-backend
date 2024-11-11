package com.eventy.events_management.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "events")

public class EventModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false )
    private UserModel organizer;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDateTime date;

    private String location;

    private Integer capacity;

    private Double ticketPrice;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "event")
    private Set<RegistrationModel> registrations;

    public Long getEventId(){
        return eventId;
    }
    public void setEventId(Long eventId){
        this.eventId = eventId;
    }

    public UserModel getOrganizer(){
        return organizer;
    }
    public void setOrganizer(UserModel organizer){
        this.organizer = organizer;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getDate(){
        return date;
    }
    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public Integer getCapacity(){
        return capacity;
    }
    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public Double getTicketPrice(){
        return ticketPrice;
    }
    public void setTicketPrice(Double ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }

    public Set<RegistrationModel> getRegistrations(){
        return registrations;
    }
    public void setRegistrations(Set<RegistrationModel> registrations){
        this.registrations = registrations;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
