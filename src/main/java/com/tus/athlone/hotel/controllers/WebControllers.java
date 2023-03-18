package com.tus.athlone.hotel.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tus.athlone.hotel.models.Booking;
import com.tus.athlone.hotel.models.Room;
import com.tus.athlone.hotel.repositories.RoomRepository;
import com.tus.athlone.hotel.services.BookingService;
import com.tus.athlone.hotel.services.RoomService;

import jakarta.validation.Valid;

@Controller
public class WebControllers {
	
	 @Autowired
	    private RoomService roomService;
	 @Autowired
	    private BookingService bookingService;
		@Autowired
		private RoomRepository roomRepository;
	
	@RequestMapping("/")
	public String showHomePage(){
		return "index.html";
	}

	
    @GetMapping("/showRooms")
    public String showRoomList(Model model) {
        List<Room> roomList = roomService.getAllRooms();
        System.out.println(roomList);
        model.addAttribute("roomList", roomList);
        return "room.html";
    } 
    
    @GetMapping("/admin")
    public String showadminPanel() {
        return "admin.html";
    }

    
    @GetMapping("/error")
    public String showaerrorPage() {
        return "error.html";
    }
    @GetMapping("/manageRooms")
    public String manageRoom() {
        return "manageRooms.html";
    }  
    
	
	  @ModelAttribute("room")
	  public Room room() {
	    return new Room();
	  }
	  

	
    @GetMapping("/addRoom")
    public String addRoom(Model model) {
        model.addAttribute("room", new Room());
        return "addRoom.html";
    } 

    
    @PostMapping("/room/add")
    public String addRoom(@ModelAttribute("room") Room room) {
    	roomService.addRoom(room);
      return "redirect:/manageRooms";
    }

    @GetMapping("/removeRoom")
    public String removeRoom(Model model) {
            List<Room> roomList = roomService.getAllRooms();
            System.out.println(roomList);
            model.addAttribute("roomList", roomList);
        return "removeRoom.html";
    } 

    
    @PostMapping("/room/remove/{id}")
    public String removeRoom(@PathVariable("id") Long id, Model model) {
    	try {
    		roomService.removeRoomById(id);
    		 return "redirect:/manageRooms";
    	}catch(Exception ex) {
    		 System.out.println("Error removing room: " + ex.getMessage());
    		 model.addAttribute("errorMessage", "An error occurred while removing the room.");
    		 return "redirect:/error";
    	}
    }
    
    @GetMapping("/showAvailableRooms")
    public String showAvailableRoomList(Model model) {
        List<Room> availableRooms = (List<Room>) model.getAttribute("availableRooms");
        model.addAttribute("availableRoomList", availableRooms);
        return "availableRooms.html";
    }

    
    @PostMapping("/room/checkAvailability")
    public String checkAvailability(@RequestParam("checkinDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkinDate,
            @RequestParam("checkoutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkoutDate,
            @RequestParam("guests") int guests,
            RedirectAttributes redirectAttributes) {
    	List<Room> availableRooms = roomService.findAvailableRooms(checkinDate, checkoutDate, guests);
    	System.out.println(availableRooms);
    	redirectAttributes.addFlashAttribute("availableRooms", availableRooms);
    	return "redirect:/showAvailableRooms";
    }
    

	
    @GetMapping("/bookRoom/form/{roomId}")
    public String bookRoom(@PathVariable  Long roomId,Model model) {
    	Room room1 = roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
    	model.addAttribute("room", room1);
    	System.out.println("Room:" + room1);
    	Booking booking1 = new Booking();
    	System.out.println(booking1);
    	booking1.setRoom(room1);
    	System.out.println("Booking" + booking1);
    	System.out.println("roomID" + booking1.getRoom());
    	model.addAttribute("booking", booking1);
    
    	
        return "book.html";
    }
    
    @PostMapping("/bookRoom/submit")
    public String submitBookingForm(@ModelAttribute("booking") Booking booking, Model model) {

    	Room room1 = roomRepository.findById(booking.getRoom().getId()).orElseThrow();
    	booking.setRoom(room1);
    	
        LocalDate checkinDate = booking.getCheckInDate();
        LocalDate checkoutDate = booking.getCheckOutDate();
        int guests = booking.getGuests();
        System.out.println("Booking Room:" +room1 );
        
        // Check room availability
        List<Room> availableRooms = roomService.findAvailableRooms(checkinDate, checkoutDate, guests);
        System.out.println("Available Room:" + availableRooms);
        if (!availableRooms.contains(room1)) {
            // Room is not available during the selected dates, show error message
        	model.addAttribute("errorMessage", "Room is not available during the selected dates, show error message.");
            return "error.html";
        }
     // Room is available, proceed with booking
        booking.setTotalCost(booking.getTotalRoomCost());
        bookingService.saveBooking(booking);
        return "bookingConfirmation.html";
    }
}