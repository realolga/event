package com.manager.event.converter;

import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class EventConverterTest {

    private EventConverter eventConverter;

    @BeforeEach
    public void setUp() {
        eventConverter = new EventConverter();
    }

    @Test
    public void whenConwertEntityToResponse() {

        EventEntity eventEntity = EventEntity.builder()
                                             .name("Test")
                                             .type(EventType.ONLINE)
                                             .description("Description")
                                             .build();

        EventResponse expectedResponse = EventResponse.builder()
                                                      .name("Test")
                                                      .type(EventType.ONLINE)
                                                      .description("Description")
                                                      .build();

        EventResponse actualResponse = eventConverter.entityToResponse(eventEntity);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void whenConwertRequestToEntity() {

        EventRequest request = EventRequest.builder()
                                           .name("Test")
                                           .type(EventType.OFFLINE)
                                           .description("Description")
                                           .build();

        EventEntity expectedEntity = EventEntity.builder()
                                                .name("Test")
                                                .type(EventType.OFFLINE)
                                                .description("Description")
                                                .build();

        EventEntity actualEntity = eventConverter.requestToEntity(request);
        assertEquals(expectedEntity, actualEntity);
    }
}