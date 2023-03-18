package com.tus.athlone.hotel.models;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "extra")
public class Extra {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private BigDecimal perNightPrice;

	    @Column(nullable = false)
	    @Enumerated(EnumType.STRING)
	    private Type type;



	    /**
	     * Allows different pricing models
	     */
	    public enum Type {
	        Premium, Basic
	    }

	

	    public Extra(String description, BigDecimal perNightPrice, Type type) {
	        this.description = description;
	        this.perNightPrice = perNightPrice;
	        this.type = type;
	    }

	    public Extra() {
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public BigDecimal getPerNightPrice() {
	        return perNightPrice;
	    }

	    public BigDecimal getTotalPrice(long totalNights) {
	        return perNightPrice.multiply(BigDecimal.valueOf(totalNights));
	    }

	    public void setPerNightPrice(BigDecimal perNightPrice) {
	        this.perNightPrice = perNightPrice;
	    }

	    public Type getType() {
	        return type;
	    }

	    public void setType(Type type) {
	        this.type = type;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Extra extra = (Extra) o;
	        return Objects.equals(description, extra.description) &&
	                type == extra.type;
	               
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(description, type);
	    }

	    @Override
	    public String toString() {
	        return "Extra{" +
	                "id=" + id +
	                ", description='" + description + '\'' +
	                ", perNightPrice=" + perNightPrice +
	                ", type=" + type +
	                ", category=" +"}";
	    }

}
