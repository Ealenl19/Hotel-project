package com.tus.athlone.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tus.athlone.hotel.models.Booking;
import com.tus.athlone.hotel.models.Extra;

public interface ExtraRepository extends JpaRepository<Extra, Long>{

}
