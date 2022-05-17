package com.manager.event.controller;

import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.repository.EventEntity;
import com.manager.event.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/event")
@AllArgsConstructor
public class EventController {

    private final EventService service;
    private final EventConverter converter;

    @GetMapping(value = "/{id}")
    public EventResponse getEvent(@PathVariable Long id) {

        EventEntity eventEntity = service.getById(id);
        return converter.EntityToResponse(eventEntity);
    }

    @PostMapping
    public EventResponse save(@RequestBody EventRequest request) {

        EventEntity event = converter.RequestToEntity(request);
        EventEntity savedEvent = service.save(event);
        return converter.EntityToResponse(savedEvent);
    }
}
