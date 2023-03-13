package com.tus.athlone.hotel.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "rooms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room {
	@Id
	@Column(unique=true)
	@GeneratedValue private Long id;
	@Column(unique=true,nullable = false)
	private int roomNo;
	@Column(nullable = false)
	private String roomType;
	@Column(nullable = false)
	private Double price;
	private Boolean smoking;
	private Boolean wifi;
	private Boolean tv;
	
	
//	@OneToMany 
//	@JoinTable(
//			name = "room_bookings",
//			joinColumns = @JoinColumn(name = "id"),
//			inverseJoinColumns = @JoinColumn(name = "bookingId"))
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "room" )
	private List <Booking> bookings;
	
	
	public Room(){
		
	}
	

	
	public Room(Long id, int roomNo, String roomType, Double price) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.price = price;
	}

	public List<Booking> getbookings(){
		return bookings;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Boolean getSmoking() {
		return smoking;
	}

	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}
	
	public void setbookings(Booking booking) {
		this.bookings.add(booking);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, roomNo, roomType, smoking, tv, wifi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return  Objects.equals(id, other.id)
				&& Objects.equals(price, other.price) && roomNo == other.roomNo
				&& Objects.equals(roomType, other.roomType) && Objects.equals(smoking, other.smoking)
				&& Objects.equals(tv, other.tv) && Objects.equals(wifi, other.wifi);
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", price=" + price + ", smoking="
				+ smoking + ", wifi=" + wifi + ", tv=" + tv  + "]";
	}





	
}
