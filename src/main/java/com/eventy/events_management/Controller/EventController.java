package com.eventy.events_management.Controller;

import com.eventy.events_management.Model.EventModel;
import com.eventy.events_management.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")

public class EventController {
    
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventModel> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public EventModel createEvent(@RequestBody EventModel event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{eventId}")
    public EventModel updateEvent(@PathVariable Long eventId, @RequestBody EventModel updatedEvent) {
        return eventService.updateEvent(eventId, updatedEvent);
    }
}



