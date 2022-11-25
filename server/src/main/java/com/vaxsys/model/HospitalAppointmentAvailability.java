package com.vaxsys.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="hospitalAppointmentAvailability")
public class HospitalAppointmentAvailability {
	@Transient
    public static final String SEQUENCE_NAME = "availableAppointments_sequence";

    @Id
    private long id;
    
    private long hospitalId;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date timeSlot;
	
	boolean isBooked = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

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

	public HospitalAppointmentAvailability(long id, long hospitalId, Date timeSlot, boolean isBooked) {
		super();
		this.id = id;
		this.hospitalId = hospitalId;
		this.timeSlot = timeSlot;
		this.isBooked = isBooked;
	}
	
}
