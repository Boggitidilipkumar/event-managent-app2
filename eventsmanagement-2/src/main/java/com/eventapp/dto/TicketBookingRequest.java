package com.eventapp.dto;

public class TicketBookingRequest {
	private int eventId;
	private int noOfTicket;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getNoOfTicket() {
		return noOfTicket;
	}
	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}
	public TicketBookingRequest(int eventId, int noOfTicket) {
		this.eventId = eventId;
		this.noOfTicket = noOfTicket;
	}
	
	
	
	

}
