package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fight_details")
public class Flight {

	@Id
	private int flightId;
	private String airline;
	private String departure;
	private String arrival;
	private int duration;
	private int seatCount;
	private long price;
	private boolean isAvailable;

	public Flight(int flightId, String airline, String departure, String arrival, int duration, int seatCount,
			long price, boolean isAvailable) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
		this.seatCount = seatCount;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public boolean getisAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}
