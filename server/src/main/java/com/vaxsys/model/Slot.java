package com.vaxsys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Slot {
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date timeSlot;
	
	boolean isBooked = true;

	public Date getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Date timeSlot) {
		this.timeSlot = timeSlot;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Slot(Date timeSlot, boolean isBooked) {
		super();
		this.timeSlot = timeSlot;
		this.isBooked = isBooked;
	}
	
}
