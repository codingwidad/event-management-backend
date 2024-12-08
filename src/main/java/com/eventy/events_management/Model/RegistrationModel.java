package com.eventy.events_management.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.eventy.events_management.Model.Enums.RegistrationStatus;

@Entity
@Table(name = "registrations")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventModel event;

    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private UserModel attendee;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;

    public RegistrationModel(){}

    public RegistrationModel(EventModel event, UserModel attendee, LocalDateTime registrationDate, RegistrationStatus status) {
        this.event = event;
        this.attendee = attendee;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public Long getRegistrationId(){
        return registrationId;
    }
    public void setRegistrationId(Long registrationId){
        this.registrationId = registrationId;
    }

    public EventModel getEvent(){
        return event;
    }
    public void setEvent(EventModel event){
        this.event = event;
    }

    public UserModel getAttendee(){
        return attendee;
    }
    public void setAttendee(UserModel attendee){
        this.attendee = attendee;
    }

    public LocalDateTime getRegistrationDate(){
        return registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate){
        this.registrationDate = registrationDate;
    }

    public RegistrationStatus getStatus(){
        return status;
    }
    public void setStatus(RegistrationStatus status){
        this.status = status;
    }
    public void confirmRegistration(){
        this.status = RegistrationStatus.CONFIRMED;
    }
    public void canceledRegistration(){
        this.status = RegistrationStatus.CANCELED;
    }
}
