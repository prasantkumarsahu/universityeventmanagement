package com.prasant.universityeventmanagement.repositories;

import com.prasant.universityeventmanagement.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEventRepository extends CrudRepository<Event, Integer> {
    public List<Event> findByDate(String date);
}
