package com.vaxsys.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="medicalStaff")
public class MedicalStaff {
		
		@Transient
	    public static final String SEQUENCE_NAME = "medicalStaff_sequence";
	
        @Id
        private long id;
        private String socialInsuranceNumber;
        private String firstName;
        private String lastName;
        @JsonFormat(pattern="yyyy-MM-dd")
        private Date dateOfBirth;
        private String jobTitle;
        private String employeeId;
        private String gender;
        private long hospitalId;
        private long phoneNumber;
        private String email;
        private String password;
        
		public MedicalStaff(long id, String socialInsuranceNumber, String firstName, String lastName, Date dateOfBirth,
				String jobTitle, String employeeId, String gender, long hospitalId, long phoneNumber, String email,
				String password) {
			super();
			this.id = id;
			this.socialInsuranceNumber = socialInsuranceNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.jobTitle = jobTitle;
			this.employeeId = employeeId;
			this.gender = gender;
			this.hospitalId = hospitalId;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.password = password;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getSocialInsuranceNumber() {
			return socialInsuranceNumber;
		}

		public void setSocialInsuranceNumber(String socialInsuranceNumber) {
			this.socialInsuranceNumber = socialInsuranceNumber;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
        
}
