package com.tus.athlone.hotel.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "bookings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
	
	@Id
	@Column(unique=true)
	@GeneratedValue private Long bookingId;
	@Column(unique=true,nullable = false)
	private Long roomId;
	@Column(nullable = false)
	private String checkIn;
	@Column(nullable = false)
	private String checkOut;
	private Boolean booked;
	private String guestName1;
	private String guestName2;
	@Column(name="bookingDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String bookingDate;
	
	@ManyToOne 
	@JoinColumn(name="roomId", referencedColumnName = "id")
	private Room room;

	
	
	public Room getRoom() {
		return room;
	}


	public Booking() {
		
	}

	
	
	public Booking(Long bookingId, Long roomId, String checkIn, String checkOut, String guestName1, String guestName2) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guestName1 = guestName1;
		this.guestName2 = guestName2;
		 
	}


	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}

	public String getGuestName1() {
		return guestName1;
	}

	public void setGuestName1(String guestName1) {
		this.guestName1 = guestName1;
	}

	public String getGuestName2() {
		return guestName2;
	}

	public void setGuestName2(String guestName2) {
		this.guestName2 = guestName2;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}




	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booked, bookingDate, bookingId, checkIn, checkOut, guestName1, guestName2, roomId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(booked, other.booked) && Objects.equals(bookingDate, other.bookingDate)
				&& Objects.equals(bookingId, other.bookingId) && Objects.equals(checkIn, other.checkIn)
				&& Objects.equals(checkOut, other.checkOut) && Objects.equals(guestName1, other.guestName1)
				&& Objects.equals(guestName2, other.guestName2) && Objects.equals(roomId, other.roomId);
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", booked=" + booked + ", guestName1=" + guestName1 + ", guestName2=" + guestName2
				+ ", bookingDate=" + bookingDate + "]";
	}
	
	
}
