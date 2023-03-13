package com.tus.athlone.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tus.athlone.hotel.models.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long>{

}
