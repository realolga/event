package com.manager.event.service;

import com.manager.event.repository.EventEntity;
import com.manager.event.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventEntity getById(Long id) {
        return repository.getById(id);
    }

    public EventEntity save(EventEntity eventEntity) {
        return repository.save(eventEntity);
    }

}
