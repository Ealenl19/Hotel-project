package com.tus.athlone.hotel.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tus.athlone.hotel.models.Booking;
import com.tus.athlone.hotel.models.Room;
import com.tus.athlone.hotel.repositories.BookingRepository;
import com.tus.athlone.hotel.repositories.RoomRepository;

@RestController
@RequestMapping("/app/v1/bookings")
public class BookingsController {

	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping
	public List<Booking> list(){
		return bookingRepository.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("{bookingId}")
	public Booking get(@PathVariable Long bookingId){
		return bookingRepository.getOne(bookingId);
	}
	
	@PostMapping
	public Booking create(@RequestBody final Booking booking) {
		return bookingRepository.saveAndFlush(booking);
	}
	
	@RequestMapping(value = "{bookingId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long bookingId) {
		bookingRepository.deleteById(bookingId);
	}
	
	@RequestMapping(value = "{bookingId}", method = RequestMethod.PUT)
	public Booking update(@PathVariable Long bookingId, @RequestBody final Booking booking) {
		
		Booking existingbooking = bookingRepository.getById(bookingId);
		BeanUtils.copyProperties(booking, existingbooking, "bookingId");
		return bookingRepository.saveAndFlush(existingbooking);
	}
}


