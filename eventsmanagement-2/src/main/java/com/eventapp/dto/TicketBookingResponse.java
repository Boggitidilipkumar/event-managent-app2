package com.eventapp.dto;

public class TicketBookingResponse {
	private String message;
	private double amountPayable;

	public TicketBookingResponse(String message, double amountPayable) {
		this.message = message;
		this.amountPayable = amountPayable;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TicketBookingResponse(String message) {
		this.message = message;
	}

	public TicketBookingResponse() {
	}

}
