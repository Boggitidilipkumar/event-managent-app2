package com.eventapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventapp.dao.EventRepo;
import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancleRequest;
import com.eventapp.dto.TicketCancleResponse;
import com.eventapp.entity.Event;
import com.eventapp.service.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	private EventRepo eventRepo;

	@Autowired
	public EventServiceImpl(EventRepo eventRepo) {
		this.eventRepo = eventRepo;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public Event findByEventId(int eventId) {
		return eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("event with id:" + eventId + "is not found"));
	}

	@Override
	public Event addEvent(Event event) {
		eventRepo.save(event);
		return event;
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		Event eventToUpdate = findByEventId(eventId);
		eventToUpdate.setEventTicketPrice(event.getEventTicketPrice());
		eventToUpdate.setDiscount(event.getDiscount());
		eventToUpdate.setNoOfTicket(event.getNoOfTicket());
		eventRepo.save(eventToUpdate);
		return eventToUpdate;
	}

	@Override
	public Event deleteEvent(int eventId) {
		Event eventToDelete = findByEventId(eventId);
		eventRepo.delete(eventToDelete);
		return eventToDelete;
	}

	@Override
	public List<Event> findByEventName(String eventName) {
		return eventRepo.findByEventName(eventName);
	}

	@Override
	public List<Event> findByEventDateBetween(LocalDate date1, LocalDate date2) {
		return eventRepo.findByEventDateBetween(date1, date2);
	}

	@Override
	public TicketBookingResponse bookTickets(TicketBookingRequest request) {
		TicketBookingResponse response = new TicketBookingResponse();
		Event eventToBook = findByEventId(request.getEventId());
		if (eventToBook == null) {
			throw new ResourceNotFoundException("event with id:" + request.getEventId() + "is not found");
		}
		if (request.getNoOfTicket() > eventToBook.getNoOfTicket()) {
			response.setMessage("no of ticket requested is more than what we can book");
			response.setAmountPayable(0.0);
		} else {
			eventToBook.setNoOfTicket(eventToBook.getNoOfTicket() - request.getNoOfTicket());
			this.updateEvent(eventToBook.getId(), eventToBook);
			response.setMessage("ticket book successfully");
			double pricePayable = (eventToBook.getEventTicketPrice() * request.getNoOfTicket())
					* (100 - eventToBook.getDiscount()) / 100;
			response.setAmountPayable(pricePayable);
		}
		return response;
	}

	@Override
	public TicketCancleResponse cancleTicket(TicketCancleRequest Request) {
		TicketCancleRequest response = new TicketCancleRequest();
		TicketCancleResponse cancleResponse = new TicketCancleResponse();
		Event eventTicketToCancle = findByEventId(Request.getEventId());
		if (eventTicketToCancle == null) {
			throw new ResourceNotFoundException("event with id:" + Request.getEventId() + "is not found");
		}
		LocalDate eventDate = eventTicketToCancle.getEventDate();
		if (eventDate.isBefore(LocalDate.now())) {
			cancleResponse.setMessage("event is already expired,we can not refund");
			cancleResponse.setAmountReturned(0.0);

		} else {

			eventTicketToCancle.setNoOfTicket(eventTicketToCancle.getNoOfTicket() + Request.getNoOfTicket());
			updateEvent(eventTicketToCancle.getId(),eventTicketToCancle);
			double amountReturned = ((eventTicketToCancle.getEventTicketPrice() * eventTicketToCancle.getNoOfTicket())
					* (100 - eventTicketToCancle.getDiscount()) / 100) * 0.5;
			cancleResponse.setAmountReturned(amountReturned);
			cancleResponse.setMessage("tickets are cancled");
		}
		return cancleResponse;
	}

}
