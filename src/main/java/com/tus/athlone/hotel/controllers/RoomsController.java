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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tus.athlone.hotel.models.Room;
import com.tus.athlone.hotel.repositories.RoomRepository;

@RestController
@RequestMapping("/app/v1/rooms")
public class RoomsController {
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping
	public List<Room> list(){
		return roomRepository.findAll();
	}
	
	
	@GetMapping
	@RequestMapping("{id}")
	public Room get(@PathVariable Long id){
		return roomRepository.getById(id);
	}
	
	@PostMapping
	public Room create(@RequestBody final Room room) {
		return roomRepository.saveAndFlush(room);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		roomRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Room update(@PathVariable Long id, @RequestBody final Room room) {
		
		Room existingRoom = roomRepository.getById(id);
		BeanUtils.copyProperties(room, existingRoom, "id");
		return roomRepository.saveAndFlush(existingRoom);
	}
	
}
