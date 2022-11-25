package com.vaxsys.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vaxsys.model.Appointment;
import com.vaxsys.model.Hospital;
import com.vaxsys.model.HospitalAppointmentAvailability;
import com.vaxsys.model.MedicalStaff;
import com.vaxsys.model.User;
import com.vaxsys.model.UserQuery;
import com.vaxsys.model.Vaccine;

@Repository
public interface VaxsysService {

	public User createUser(User user);
	public MedicalStaff createMedicalStaff(MedicalStaff medicalStaff);
	public List<MedicalStaff> showAllMedicalStaffDetails();
	public List<User> showAllUsers();
	public boolean validateUserLogin(String email, String password);
	public boolean validateMedicalStaffLogin(String email, String password);
	public Appointment createAppointment(Appointment appointment);
	public Hospital createHospital(Hospital hospital);
	public Vaccine createVaccine(Vaccine vaccine);
	public List<Vaccine> findVaccineByDisease(String diseaseName);
	public void deleteAppointment(long appointmentId);
	public List<Hospital> showAllHospitalDetails();
	public HospitalAppointmentAvailability addAvailableSlots(HospitalAppointmentAvailability hospitalAppointmentAvailability);
	public List<HospitalAppointmentAvailability> getAvailableSlots(HospitalAppointmentAvailability hospitalAppointmentAvailability);
	public List<Appointment> getCurrentDateAppointments();
	public List<Vaccine> getVaccines();
	public Appointment modifyAppointment(long appointmentId, Appointment appointment);
	public void registerUserQuery(UserQuery userQuery);
	
}
