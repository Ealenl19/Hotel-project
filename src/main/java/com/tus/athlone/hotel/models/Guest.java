package com.tus.athlone.hotel.models;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "guest")
public class Guest {
	
	@Transient
    private UUID tempId = UUID.randomUUID();

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	

    @Size(min = 1, max = 3)
    @NotNull(message = "required")
    @Column(nullable = false)
    private String customerName;


    private boolean child;
    

    public Guest(String customerName, boolean child) {
        setCustomerName(customerName);
        this.child = child;
    }

    public Guest() {
    }
    public String getcustomerName() {
        return customerName;
    }

    /**
     * Converts to lowercase for consistent equality checks
     */
    public void setCustomerName(String firstName) {
        this.customerName = firstName.toLowerCase();
    }


    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public UUID getTempId() {
        return tempId;
    }
    
//    public static Comparator<Guest> comparator() {
//        return Comparator.comparing(Guest::isChild, Boolean::compareTo)
//                .thenComparing(Guest::getCustomerName)
//                .thenComparing(Guest::getLastName);
//    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return child == guest.child &&
                Objects.equals(customerName, guest.customerName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, child);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + customerName + '\'' +
                ", child=" + child +
                '}';
    }

}
