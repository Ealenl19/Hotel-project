package com.tus.athlone.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tus.athlone.hotel.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
