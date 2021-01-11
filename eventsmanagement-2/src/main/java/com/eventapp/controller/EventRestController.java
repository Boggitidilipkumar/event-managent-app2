package com.eventapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.entity.Event;
import com.eventapp.service.EventService;

@RestController
@RequestMapping("admin")
public class EventRestController {

	private EventService eventService;

	@Autowired
	public EventRestController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping(path = "event", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getAllEvents() {
		List<Event> events = eventService.getAllEvents();
		return events;

	}

	@GetMapping(path = "event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Event getEventById(@PathVariable(name = "id") int id) {
		Event events = eventService.findByEventId(id);
		return events;

	}

	@GetMapping(path = "event/byname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getEventByName(@PathVariable(name = "name") String eventName) {
		List<Event> events = eventService.findByEventName(eventName);
		return events;

	}

	@DeleteMapping(path = "event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Event deleteEvent(@PathVariable(name = "id") int id) {
		Event events = eventService.deleteEvent(id);
		return events;

	}

	@PutMapping(path = "event/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Event updateEvent(@PathVariable(name = "id") int id, @RequestBody Event event) {
		Event events = eventService.updateEvent(id, event);
		return events;

	}

	@PostMapping(path = "event", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Event addEvent(@RequestBody Event event) {
		Event events = eventService.addEvent(event);
		return events;

	}


	@PostMapping(path = "booking", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public TicketBookingResponse bookingEventTickets(@RequestBody TicketBookingRequest eventRequest) {
		return eventService.bookTickets(eventRequest);

	}
	
	@PostMapping(path = "cancle", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public TicketCancleResponse cancleEventTicketbooking(@RequestBody TicketCancleRequest cancleRequest) {
		return eventService.cancleTicket(cancleRequest);

	}
}
