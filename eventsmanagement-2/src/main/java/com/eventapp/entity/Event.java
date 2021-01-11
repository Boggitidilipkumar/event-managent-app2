package com.eventapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="event_table")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String eventName;
	private String eventLocation;
	private double eventTicketPrice;
	private double discount;
	private int noOfTicket;
	private LocalDate eventDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public double getEventTicketPrice() {
		return eventTicketPrice;
	}

	public void setEventTicketPrice(double eventTicketPrice) {
		this.eventTicketPrice = eventTicketPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public Event(String eventName, String eventLocation, double eventTicketPrice, double discount, int noOfTicket,
			LocalDate eventDate) {
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventTicketPrice = eventTicketPrice;
		this.discount = discount;
		this.noOfTicket = noOfTicket;
		this.eventDate = eventDate;
	}

	public Event() {
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventLocation=" + eventLocation
				+ ", eventTicketPrice=" + eventTicketPrice + ", discount=" + discount + ", noOfTicket=" + noOfTicket
				+ ", eventDate=" + eventDate + "]";
	}

}
