package com.eventapp.service;
import java.time.LocalDate;
import java.util.*;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.entity.Event;
public interface EventService {
	
	public List<Event> getAllEvents();
	public Event findByEventId(int eventId);
	public Event addEvent(Event event);
	public Event updateEvent(int eventId,Event event);
	public Event deleteEvent(int eventId);
	public List<Event>findByEventName(String eventName);
	public TicketBookingResponse bookTickets(TicketBookingRequest Request );
	public TicketCancleResponse cancleTicket(TicketCancleRequest Request);
	public List<Event>findByEventDateBetween(LocalDate date1,LocalDate date2);

}
