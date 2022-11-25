package com.vaxsys.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaxsys.model.Appointment;
import com.vaxsys.model.Hospital;
import com.vaxsys.model.HospitalAppointmentAvailability;
import com.vaxsys.model.MedicalStaff;
import com.vaxsys.model.User;
import com.vaxsys.model.UserQuery;
import com.vaxsys.model.Vaccine;
import com.vaxsys.service.VaxsysService;

@RestController
public class VaxsysController {
	
	@Autowired
	VaxsysService vaxsysService;
	
	@PostMapping("/users")
    public ResponseEntity < User > createItem(@RequestBody User user) {    	

    	return ResponseEntity.ok().body(vaxsysService.createUser(user));
    }
	
	@PostMapping("/medicalStaff")
    public ResponseEntity < MedicalStaff > createMedicalStaff(@RequestBody MedicalStaff medicalStaff) {    	

    	return ResponseEntity.ok().body(vaxsysService.createMedicalStaff(medicalStaff));
    }
	
	@GetMapping("/users")
    public ResponseEntity < List < User >> getAllUsers() {
    	
    	return ResponseEntity.ok().body(vaxsysService.showAllUsers());
    }
	
	@GetMapping("/medicalStaff")
    public ResponseEntity < List < MedicalStaff >> getAllItems() {
    	
    	return ResponseEntity.ok().body(vaxsysService.showAllMedicalStaffDetails());
    }
	
	@PostMapping("/userLogin")
    public HttpStatus validateUserLogin(@RequestBody User user) {
    	if(user.getEmail() == null || user.getEmail().isEmpty()) {
    		return HttpStatus.BAD_REQUEST;
    	} else if(user.getPassword() == null || user.getPassword().isEmpty()) {
    		return HttpStatus.BAD_REQUEST;
    	}
    	boolean valid = vaxsysService.validateUserLogin(user.getEmail(), user.getPassword());
    	return valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
    }
	
	@PostMapping("/medicalStaffLogin")
    public HttpStatus validateMedicalStaffLogin(@RequestBody MedicalStaff medicalStaff) {
		if(medicalStaff.getEmail() == null || medicalStaff.getEmail().isEmpty()) {
    		return HttpStatus.BAD_REQUEST;
    	} else if(medicalStaff.getPassword() == null || medicalStaff.getPassword().isEmpty()) {
    		return HttpStatus.BAD_REQUEST;
    	}
    	boolean valid = vaxsysService.validateMedicalStaffLogin(medicalStaff.getEmail(), medicalStaff.getPassword());
    	return valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
    }
	
	@PostMapping("/appointments")
    public ResponseEntity < Appointment > createApointment(@RequestBody Appointment appointment) {    	

    	return ResponseEntity.ok().body(vaxsysService.createAppointment(appointment));
    }
	
	@DeleteMapping("/appointments/{appointmentId}")
    public HttpStatus deleteAppointment(@PathVariable long appointmentId) {

		vaxsysService.deleteAppointment(appointmentId);
        return HttpStatus.OK;
    }
	
	@PostMapping("/modifyAppointment/{appointmentId}")
    public Appointment modifyAppointment(@PathVariable long appointmentId, @RequestBody Appointment appointment) {

		Appointment modifiedAppointment = vaxsysService.modifyAppointment(appointmentId, appointment);
        return modifiedAppointment;
    }
	
	@GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
		return vaxsysService.getCurrentDateAppointments();
    }
	
	@PostMapping("/hospitals")
    public ResponseEntity < Hospital > createHospital(@RequestBody Hospital hospital) {    	

    	return ResponseEntity.ok().body(vaxsysService.createHospital(hospital));
    }
	
	@GetMapping("/hospitals")
    public ResponseEntity < List<Hospital> > getAllHospitals() {    	

    	return ResponseEntity.ok().body(vaxsysService.showAllHospitalDetails());
    }
	
	@PostMapping("/vaccines")
    public ResponseEntity < Vaccine > createVaccine(@RequestBody Vaccine vaccine) {    	

    	return ResponseEntity.ok().body(vaxsysService.createVaccine(vaccine));
    }
	
	@GetMapping("/vaccines")
    public ResponseEntity < List<Vaccine> > createVaccine() {    	

    	return ResponseEntity.ok().body(vaxsysService.getVaccines());
    }
	
	@PostMapping("/vaccinesByDisease")
    public ResponseEntity < List<Vaccine> > getVaccinesByDisease(@RequestBody Vaccine vaccine) {    	
		if(vaccine.getDiseaseName() == null || vaccine.getDiseaseName().isEmpty()) {
    		return ResponseEntity.badRequest().body(null);
    	} 
    	return ResponseEntity.ok().body(vaxsysService.findVaccineByDisease(vaccine.getDiseaseName()));
    }
	
	@PostMapping("/hospitalAppointmentAvailability")
    public ResponseEntity < HospitalAppointmentAvailability> addAvailableSlots(@RequestBody HospitalAppointmentAvailability hospitalAppointmentAvailability) {    	
		
    	return ResponseEntity.ok().body(vaxsysService.addAvailableSlots(hospitalAppointmentAvailability));
    }
	
	@PostMapping("/getAvailableSlotsForHospital")
    public ResponseEntity < List<HospitalAppointmentAvailability>> getAvailableSlots(@RequestBody HospitalAppointmentAvailability hospitalAppointmentAvailability) {    	
		
    	return ResponseEntity.ok().body(vaxsysService.getAvailableSlots(hospitalAppointmentAvailability));
    }
	
	@PostMapping("/registerQuery")
    public HttpStatus registerUserQuery(@RequestBody UserQuery userQuery) {    	
		
    	vaxsysService.registerUserQuery(userQuery);
    	return HttpStatus.OK;
    }
	
	
}
