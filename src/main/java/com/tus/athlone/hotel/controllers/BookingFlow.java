package com.tus.athlone.hotel.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tus.athlone.hotel.models.Booking;

import jakarta.validation.Valid;

public class BookingFlow {
	
	public enum Step {
        Dates(0),
        Guests(1),
        Extras(3),
        Review(4),
        Payment(5);

        int flowStep;

        Step(int flowStep) {
            this.flowStep = flowStep;
        }
        
        public static Step from(int flowStep) {
            switch (flowStep) {
                case 0:
                    return Dates;
                case 1:
                    return Guests;
                case 2:
                    return Extras;
                case 4:
                    return Review;
                case 5:
                    return Payment;
                default:
                    return Dates;
            }
        }
	}
    
        
        @Valid
        private Booking booking = new Booking();
        private Step activeStep = Step.Dates;


        private Set<Step> completedSteps = new HashSet<>();

        public Booking getBooking() {
            return booking;
        }

        public void setBooking(Booking booking) {
            this.booking = booking;
        }

        public void setActive(Step step) {
            activeStep = step;
        }

        public Step getActiveStep() {
            return activeStep;
        }
        
        public void completeStep(Step step) {
            completedSteps.add(step);
        }
        
        public void incompleteStep(Step step) {
            completedSteps.remove(step);
        }
        
        public boolean isActive(Step step) {
            return step == activeStep;
        }
        
        public boolean isCompleted(Step step) {
            return completedSteps.contains(step);
        }

        public void enterStep(Step step) {
            setActive(step);
            incompleteStep(step);
        }
        


  
    }


