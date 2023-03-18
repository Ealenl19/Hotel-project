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
	@RequestMapping("{customer_id}")
	public Customer get(@PathVariable Long customer_id){
		return customerRepository.getById(customer_id);
	}
	@PostMapping
	public Customer create(@RequestBody final Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	@RequestMapping(value = "{customer_id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long customer_id) {
		customerRepository.deleteById(customer_id);
	}
	
	@RequestMapping(value = "{customer_id}", method = RequestMethod.PUT)
	public Customer update(@PathVariable Long customer_id, @RequestBody final Customer customer) {
		
		Customer existingCustomer = customerRepository.getById(customer_id);
		BeanUtils.copyProperties(customer, existingCustomer, "customer_id");
		return customerRepository.saveAndFlush(existingCustomer);
	}
}
