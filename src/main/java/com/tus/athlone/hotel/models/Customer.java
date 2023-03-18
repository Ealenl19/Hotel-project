package com.tus.athlone.hotel.models;

import java.util.Objects;

import org.hibernate.annotations.Type;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Provider;
import org.springframework.ui.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;



@Entity(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	@Id
	@Column(unique=true)
	@GeneratedValue private Long customer_id;
	@Column(nullable = false)
	@NotEmpty
	private String customer_name;
	@Column(unique=true,nullable = false)
	private String email_id;
	private String phone_number;
	
	private String address;
	private String country;
	@Column(unique=true,nullable = false)
	private String passport;
	private String password;
	
	@Enumerated(EnumType.STRING)
    private Provider provider;
	
	public enum Provider {
	    LOCAL, GOOGLE
	}
 
    public Provider getProvider() {
        return provider;
    }
 
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
	
	
	
	public Customer() {
		
		}



	public Customer(Long customer_id, String customer_name, String email_id, String phone_number, String address,
			String country, String passport, String password) {
		super();
		this.customer_name = customer_name;
		this.email_id = email_id;
		this.phone_number = phone_number;
		this.address = address;
		this.country = country;
		this.passport = passport;
		this.password = password;
	}



	public Long getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}



	public String getCustomer_name() {
		return customer_name;
	}



	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}



	public String getEmail_id() {
		return email_id;
	}



	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}



	public String getPhone_number() {
		return phone_number;
	}



	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPassport() {
		return passport;
	}



	public void setPassport(String passport) {
		this.passport = passport;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		return Objects.hash(address, country, customer_id, customer_name, email_id, passport, password, phone_number);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(country, other.country)
				&& Objects.equals(customer_id, other.customer_id) && Objects.equals(customer_name, other.customer_name)
				&& Objects.equals(email_id, other.email_id) && Objects.equals(passport, other.passport)
				&& Objects.equals(password, other.password) && Objects.equals(phone_number, other.phone_number);
	}



	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", email_id=" + email_id
				+ ", phone_number=" + phone_number + ", address=" + address + ", country=" + country + ", passport="
				+ passport + ", password=" + password + "]";
	}



	
	
}
