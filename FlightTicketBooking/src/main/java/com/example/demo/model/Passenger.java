package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="passenger_details")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passId;
	private int bookId;
	private String name;
	private int age;
	private String gender;
	private int passSeat;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(int passId, int bookId, String name, int age, String gender, int passSeat) {
		super();
		this.passId = passId;
		this.bookId = bookId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.passSeat = passSeat;
	}
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPassSeat() {
		return passSeat;
	}
	public void setPassSeat(int passSeat) {
		this.passSeat = passSeat;
	}
	
}
