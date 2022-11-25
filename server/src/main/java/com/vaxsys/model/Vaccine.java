package com.vaxsys.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="vaccines")
public class Vaccine {
	
	@Transient
    public static final String SEQUENCE_NAME = "vaccines_sequence";
	
	@Id
	private long id;
	
    private String vaccineName;
    
    private String diseaseName;
    private String doseDetails;
    private String description;
    private int dose;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDoseDetails() {
		return doseDetails;
	}
	public void setDoseDetails(String doseDetails) {
		this.doseDetails = doseDetails;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}		
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	public Vaccine(long id, String vaccineName, String diseaseName, String doseDetails, String description, int dose) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
		this.diseaseName = diseaseName;
		this.doseDetails = doseDetails;
		this.description = description;
		this.dose = dose;
	}
}
