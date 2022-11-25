package com.vaxsys.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="user")
public class User {
		
		@Transient
	    public static final String SEQUENCE_NAME = "users_sequence";
	
        @Id
        private long id;

        private String socialInsuranceNumber;
        private String firstName;
        private String lastName;
        @JsonFormat(pattern="yyyy-MM-dd")
        private Date dateOfBirth;
        private String addressLine1;
        private String city;
        private String postalCode;
        private String province;
        private String country;
        private String healthCard;
        private List<String> disease;
        
        private String gender;
        
        private long phoneNumber;
        private String email;
        private String password;
        
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
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
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
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getHealthCard() {
			return healthCard;
		}
		public void setHealthCard(String healthCard) {
			this.healthCard = healthCard;
		}
		public List<String> getDisease() {
			return disease;
		}
		public void setDisease(List<String> disease) {
			this.disease = disease;
		}
		
		public User(long id, String socialInsuranceNumber, String firstName, String lastName, Date dateOfBirth,
				String addressLine1, String city, String postalCode, String province, String country, String healthCard,
				List<String> disease, String gender, long phoneNumber, String email, String password) {
			super();
			this.id = id;
			this.socialInsuranceNumber = socialInsuranceNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.addressLine1 = addressLine1;
			this.city = city;
			this.postalCode = postalCode;
			this.province = province;
			this.country = country;
			this.healthCard = healthCard;
			this.disease = disease;
			this.gender = gender;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.password = password;
		}
       
}
