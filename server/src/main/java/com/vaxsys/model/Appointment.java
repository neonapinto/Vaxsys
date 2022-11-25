package com.vaxsys.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="appointments")
public class Appointment {
	
	@Transient
    public static final String SEQUENCE_NAME = "appointments_sequence";
	
	@Id
	private long id;
	
	private long userId;
	private long vaccineId;
	private long hospitalId;	
	private long phoneNumber;
    private String email;
    private boolean vaccinated;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date appointmentDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public long getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public Appointment(long id, long userId, long vaccineId, long hospitalId, long phoneNumber, String email,
			boolean vaccinated, Date appointmentDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.vaccineId = vaccineId;
		this.hospitalId = hospitalId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vaccinated = vaccinated;
		this.appointmentDate = appointmentDate;
	}	
}
