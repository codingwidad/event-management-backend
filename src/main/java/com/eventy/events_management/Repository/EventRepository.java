package com.eventy.events_management.Repository;

import com.eventy.events_management.Model.EventModel;
import com.eventy.events_management.Model.UserModel;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface EventRepository extends JpaRepository<EventModel, Long> {
    List<EventModel> findByTitle(String title);
    List<EventModel> findByLocation(String location);
    List<EventModel> findByDate(LocalDateTime date);
    List<EventModel> findByOrganizer(UserModel organizer);
    List<EventModel> findByTicketPriceLessThanEqual(Double ticketPrice);
    List<EventModel> findByTitleContaining(String keyword);
    List<EventModel> findByLocationAndTime(String location, LocalDateTime date);
}
