package com.eventy.events_management.Service;

import com.eventy.events_management.Model.EventModel;
import com.eventy.events_management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<EventModel> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public EventModel createEvent(EventModel event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    
    public EventModel updateEvent(Long eventId, EventModel updatedEvent) {

        Optional<EventModel> existingEventOpt = eventRepository.findById(eventId);
        
        if (existingEventOpt.isPresent()) {
            EventModel existingEvent = existingEventOpt.get();

            if (updatedEvent.getTitle() != null) {
                existingEvent.setTitle(updatedEvent.getTitle());
            }
            if (updatedEvent.getDescription() != null) {
                existingEvent.setDescription(updatedEvent.getDescription());
            }
            if (updatedEvent.getDate() != null) {
                existingEvent.setDate(updatedEvent.getDate());
            }
            if (updatedEvent.getLocation() != null) {
                existingEvent.setLocation(updatedEvent.getLocation());
            }
            if (updatedEvent.getCapacity() != null) {
                existingEvent.setCapacity(updatedEvent.getCapacity());
            }
            if (updatedEvent.getTicketPrice() != null) {
                existingEvent.setTicketPrice(updatedEvent.getTicketPrice());
            }

            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with ID " + eventId);
        }
    }
}


