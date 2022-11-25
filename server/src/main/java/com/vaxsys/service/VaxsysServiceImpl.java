package com.vaxsys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaxsys.model.Appointment;
import com.vaxsys.model.Hospital;
import com.vaxsys.model.HospitalAppointmentAvailability;
import com.vaxsys.model.MedicalStaff;
import com.vaxsys.model.User;
import com.vaxsys.model.UserQuery;
import com.vaxsys.model.Vaccine;
import com.vaxsys.repository.AppointmentRepository;
import com.vaxsys.repository.HospitalAppointmentAvailabilityRepo;
import com.vaxsys.repository.HospitalRepository;
import com.vaxsys.repository.MedicalStaffRepository;
import com.vaxsys.repository.SequenceGeneratorService;
import com.vaxsys.repository.UserQueryRepository;
import com.vaxsys.repository.UserRepository;
import com.vaxsys.repository.VaccineRepository;

@Service
@Transactional
public class VaxsysServiceImpl implements VaxsysService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MedicalStaffRepository medicalStaffRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	VaccineRepository vaccineRepository;

	@Autowired
	HospitalAppointmentAvailabilityRepo hospitalAppointmentAvailabilityRepo;

	@Autowired
	UserQueryRepository userQueryRepository;

	@Autowired
	SequenceGeneratorService sequenceGenerator;

	@Override
	public User createUser(User user) {
		System.out.println("User Data creation started...");
		user.setId(sequenceGenerator.getNextSequence(user.SEQUENCE_NAME));
		return userRepository.save(user);
	}

	@Override
	public MedicalStaff createMedicalStaff(MedicalStaff medicalStaff) {
		System.out.println("Medical staff Data creation started...");
		medicalStaff.setId(sequenceGenerator.getNextSequence(medicalStaff.SEQUENCE_NAME));
		return medicalStaffRepository.save(medicalStaff);
	}

	@Override
	public List<User> showAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public List<MedicalStaff> showAllMedicalStaffDetails() {

		return medicalStaffRepository.findAll();
	}

	@Override
	public boolean validateUserLogin(String email, String password) {
		User user = userRepository.findByEmail(email);
		return user != null && user.getPassword().equals(password);
	}

	@Override
	public boolean validateMedicalStaffLogin(String email, String password) {
		User user = medicalStaffRepository.findByEmail(email);
		return user != null && user.getPassword().equals(password);
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		System.out.println("Appointment Data creation started...");

		List<HospitalAppointmentAvailability> availableHospitalSlots = hospitalAppointmentAvailabilityRepo
				.findAvailabilityByHospitalId(appointment.getHospitalId());

		availableHospitalSlots.stream()
				.filter(slot -> !slot.isBooked() && slot.getTimeSlot().equals(appointment.getAppointmentDate()))
				.findFirst().get().setBooked(true);
		hospitalAppointmentAvailabilityRepo.saveAll(availableHospitalSlots);

		appointment.setId(sequenceGenerator.getNextSequence(appointment.SEQUENCE_NAME));
		appointment.setVaccinated(false);
		return appointmentRepository.save(appointment);
	}

	@Override
	public Hospital createHospital(Hospital hospital) {
		System.out.println("Hospital Data creation started...");
		hospital.setId(sequenceGenerator.getNextSequence(hospital.SEQUENCE_NAME));
		return hospitalRepository.save(hospital);
	}

	@Override
	public Vaccine createVaccine(Vaccine vaccine) {
		vaccine.setId(sequenceGenerator.getNextSequence(vaccine.SEQUENCE_NAME));
		return vaccineRepository.save(vaccine);
	}

	@Override
	public List<Vaccine> findVaccineByDisease(String diseaseName) {
		return vaccineRepository.findByDiseaseName(diseaseName);
	}

	@Override
	public void deleteAppointment(long appointmentId) {
		Optional<Appointment> appointmentToDelete = appointmentRepository.findById(appointmentId);
		if (appointmentToDelete != null && appointmentToDelete.get() != null) {
			List<HospitalAppointmentAvailability> availableHospitalSlots = hospitalAppointmentAvailabilityRepo
					.findAvailabilityByHospitalId(appointmentToDelete.get().getHospitalId());

			availableHospitalSlots.stream()
					.filter(slot -> slot.isBooked()
							&& slot.getTimeSlot().equals(appointmentToDelete.get().getAppointmentDate()))
					.findFirst().get().setBooked(false);
			hospitalAppointmentAvailabilityRepo.saveAll(availableHospitalSlots);
		}
		appointmentRepository.deleteById(appointmentId);
		System.out.println("Vaccination appointment with id " + appointmentId + " deleted...");

	}

	@Override
	public Appointment modifyAppointment(long appointmentId, Appointment appointment) {

		Optional<Appointment> appointmentToModify = appointmentRepository.findById(appointmentId);
		if (appointmentToModify != null && appointmentToModify.get() != null) {
			if (!appointmentToModify.get().getAppointmentDate().equals(appointment.getAppointmentDate())
					|| appointmentToModify.get().getHospitalId() != appointment.getHospitalId()) {
				List<HospitalAppointmentAvailability> oldHospitalSlots = hospitalAppointmentAvailabilityRepo
						.findAvailabilityByHospitalId(appointmentToModify.get().getHospitalId());
				oldHospitalSlots.stream()
						.filter(slot -> slot.isBooked()
								&& slot.getTimeSlot().equals(appointmentToModify.get().getAppointmentDate()))
						.findFirst().get().setBooked(false);
				hospitalAppointmentAvailabilityRepo.saveAll(oldHospitalSlots);

				List<HospitalAppointmentAvailability> newHospitalSlots = hospitalAppointmentAvailabilityRepo
						.findAvailabilityByHospitalId(appointment.getHospitalId());
				newHospitalSlots.stream()
						.filter(slot -> !slot.isBooked() && slot.getTimeSlot().equals(appointment.getAppointmentDate()))
						.findFirst().get().setBooked(true);
				hospitalAppointmentAvailabilityRepo.saveAll(newHospitalSlots);

				appointmentToModify.get().setAppointmentDate(appointment.getAppointmentDate());
				appointmentToModify.get().setHospitalId(appointment.getHospitalId());

				appointmentRepository.save(appointmentToModify.get());

			} else if (appointment.isVaccinated()) {
				appointmentToModify.get().setVaccinated(appointment.isVaccinated());
				appointmentRepository.save(appointmentToModify.get());
			}
			return appointmentToModify.get();
		}
		return appointment;
	}

	@Override
	public List<Hospital> showAllHospitalDetails() {
		return hospitalRepository.findAll();
	}

	@Override
	public HospitalAppointmentAvailability addAvailableSlots(
			HospitalAppointmentAvailability hospitalAppointmentAvailability) {
		hospitalAppointmentAvailability
				.setId(sequenceGenerator.getNextSequence(hospitalAppointmentAvailability.SEQUENCE_NAME));
		return hospitalAppointmentAvailabilityRepo.save(hospitalAppointmentAvailability);
	}

	@Override
	public List<HospitalAppointmentAvailability> getAvailableSlots(
			HospitalAppointmentAvailability hospitalAppointmentAvailability) {
		List<HospitalAppointmentAvailability> availableHospitalSlots = hospitalAppointmentAvailabilityRepo
				.findAvailabilityByHospitalId(hospitalAppointmentAvailability.getHospitalId());
		if (availableHospitalSlots != null && !availableHospitalSlots.isEmpty()) {
			List<HospitalAppointmentAvailability> availableSlots = availableHospitalSlots.stream()
					.filter(slot -> !slot.isBooked()).collect(Collectors.toList());
			return availableSlots;
		}

		return new ArrayList<HospitalAppointmentAvailability>();
	}

	@Override
	public List<Appointment> getCurrentDateAppointments() {
		Date date = new Date();

		List<Appointment> allAppointments = appointmentRepository.findAll();
		if (allAppointments != null) {
			return allAppointments.stream()
					.filter(ap -> ap.getAppointmentDate().getDay() == date.getDay()
							&& ap.getAppointmentDate().getMonth() == date.getMonth()
							&& ap.getAppointmentDate().getYear() == date.getYear())
					.collect(Collectors.toList());
		}
		return new ArrayList<Appointment>();
	}

	@Override
	public List<Vaccine> getVaccines() {
		return vaccineRepository.findAll();
	}

	@Override
	public void registerUserQuery(UserQuery userQuery) {
		userQuery.setId(sequenceGenerator.getNextSequence(userQuery.SEQUENCE_NAME));
		userQueryRepository.save(userQuery);

	}

}
