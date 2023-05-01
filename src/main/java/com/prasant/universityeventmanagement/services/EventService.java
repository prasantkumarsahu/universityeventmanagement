package com.prasant.universityeventmanagement.services;

import com.prasant.universityeventmanagement.models.Event;
import com.prasant.universityeventmanagement.repositories.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepository iEventRepository;

    public String addEventToDb(Event event) {
        iEventRepository.save(event);
        return "Event added1";
    }
    public String updateEvent(Event event) {
        if(iEventRepository.findById(event.getEventId()).orElse(null) != null) {
            iEventRepository.save(event);
            return "Event updated!";
        }
        else
            return "Invalid Event Id";
    }

    public String deleteEventById(Integer id) {
        if(iEventRepository.findById(id).orElse(null) != null) {
            iEventRepository.deleteById(id);
            return "Event deleted!";
        }
        else
            return "Invalid Event Id";
    }
    public List<Event> getAllEventsByDate(String date) {
        return iEventRepository.findByDate(date);
    }
}
