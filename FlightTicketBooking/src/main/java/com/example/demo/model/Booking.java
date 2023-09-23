package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings_table")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name ="fk_user_id")
	private User userId;
	private int flightId;
	private int numSeats;
	private long price;
	private String bookingDateAndTime;
	private String className;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name ="fk_flight_details")
	private Flight flight;
	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(name ="fk_passenger_details")
	private List<Passenger> listPassengers;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getBookingDateAndTime() {
		return bookingDateAndTime;
	}
	public void setBookingDateAndTime(String bookingDateAndTime) {
		this.bookingDateAndTime = bookingDateAndTime;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<Passenger> getListPassengers() {
		return listPassengers;
	}
	public void setListPassengers(List<Passenger> listPassengers) {
		this.listPassengers = listPassengers;
	}
	public Booking(int bookingId, User userId, int flightId, int numSeats, long price, String bookingDateAndTime,
			String className, Flight flight, List<Passenger> listPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.numSeats = numSeats;
		this.price = price;
		this.bookingDateAndTime = bookingDateAndTime;
		this.className = className;
		this.flight = flight;
		this.listPassengers = listPassengers;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
	
}
