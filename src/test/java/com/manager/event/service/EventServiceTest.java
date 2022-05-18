package com.manager.event.service;

import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;
import com.manager.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
class EventServiceTest {

    //    @Mock
    EventRepository repository;

    //    @InjectMocks
    EventService eventService;

    @BeforeEach
    void setUp() {

        repository = Mockito.mock(EventRepository.class);
        eventService = new EventService(repository);
        EventEntity entity = getTestEntity();
        Mockito.when(repository.getById(anyLong())).thenReturn(entity);
    }

    @Test
    void testGettingById() {
        EventEntity eventEntity = eventService.getById(1l);
        EventEntity expectedEntity = getTestEntity();
        assertEquals(expectedEntity, eventEntity);
    }

//    @Test
//    void testSaving() {
//
//        eventService.save(getTestEntity());
//        eventService.save(getTestEntity());
//
//        Mockito.verify(eventService).save(getTestEntity());
//        Mockito.verify(eventService).save(getTestEntity());
//
//    }

    private EventEntity getTestEntity() {
        return EventEntity.builder()
                          .name("Test")
                          .type(EventType.OFFLINE)
                          .description("Description")
                          .build();
    }
}