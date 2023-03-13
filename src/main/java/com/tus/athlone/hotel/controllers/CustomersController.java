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

import com.tus.athlone.hotel.models.Customer;
import com.tus.athlone.hotel.models.Room;
import com.tus.athlone.hotel.repositories.CustomerRepository;
import com.tus.athlone.hotel.repositories.RoomRepository;

@RestController
@RequestMapping("/app/v1/customers")
public class CustomersController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> list(){
		return customerRepository.findAll();
	}
	
	
	@GetMapping
	@RequestMapping("{customerId}")
	public Customer get(@PathVariable Long customerId){
		return customerRepository.getById(customerId);
	}
	@PostMapping
	public Customer create(@RequestBody final Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	@RequestMapping(value = "{customerId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long customerId) {
		customerRepository.deleteById(customerId);
	}
	
	@RequestMapping(value = "{customerId}", method = RequestMethod.PUT)
	public Customer update(@PathVariable Long customerId, @RequestBody final Customer customer) {
		
		Customer existingCustomer = customerRepository.getById(customerId);
		BeanUtils.copyProperties(customer, existingCustomer, "customerId");
		return customerRepository.saveAndFlush(existingCustomer);
	}
}
