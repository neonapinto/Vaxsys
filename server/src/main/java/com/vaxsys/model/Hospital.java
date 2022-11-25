package com.vaxsys.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hospitals")
public class Hospital {
	@Transient
    public static final String SEQUENCE_NAME = "hospitals_sequence";

    @Id
    private long id;
    
    private String hospitalName;
    private String hospitalAddressLine1;
    private String addressLine1;
    private String city;
    private String postalCode;
    private String province;
    private String country;
    private long hospitalPhoneNumber;
    private String govtApprovalNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddressLine1() {
		return hospitalAddressLine1;
	}
	public void setHospitalAddressLine1(String hospitalAddressLine1) {
		this.hospitalAddressLine1 = hospitalAddressLine1;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
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
	public long getHospitalPhoneNumber() {
		return hospitalPhoneNumber;
	}
	public void setHospitalPhoneNumber(long hospitalPhoneNumber) {
		this.hospitalPhoneNumber = hospitalPhoneNumber;
	}
	public String getGovtApprovalNumber() {
		return govtApprovalNumber;
	}
	public void setGovtApprovalNumber(String govtApprovalNumber) {
		this.govtApprovalNumber = govtApprovalNumber;
	}
	public Hospital(long id, String hospitalName, String hospitalAddressLine1, String addressLine1, String city,
			String postalCode, String province, String country, long hospitalPhoneNumber, String govtApprovalNumber) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.hospitalAddressLine1 = hospitalAddressLine1;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
		this.country = country;
		this.hospitalPhoneNumber = hospitalPhoneNumber;
		this.govtApprovalNumber = govtApprovalNumber;
	}
    
	
    
}
