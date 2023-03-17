package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS_DT_CLAIM_BODILY_INJURY")
public class CarsDtClaimBodilyInjury {

	@Id
	@Column(name = "DT_ID")
	private String dtId;
	
	@Column(name = "INJURED_ID")
	private String injuredId;
	
	@Column(name =  "INJURED_NOTIFICATION_ID")
	private String injuredNotificationId;
	
	@Column(name ="INJURED_SEQ")
	private String injuredSeq;
	
	@Column(name = "INJURED_FAMILY")
	private String bodilyLastName;
	
	@Column (name = "INJURED_FIRST_NAME")
	private String bodilyFirstName;
	
	@Column(name = "INJURED_FATHER")
	private String injuredFather;
	
	@Column(name = "INJURED_GENDER")
	private String injuredGender;
	
	@Column(name = "INJURED_PLACE")
	private String injuredPlace ;
	
	@Column (name = "INJURED_MOBILE")
	private String bodilyMobileNumber;
	
	@Column (name = "INJURED_HOSPITAL_ID")
	private String injuredHospitalId;
	
	@Column (name = "INJURED_DATE_OF_BIRTH")
	private String bodilyDob;
	
	@Column (name = "INJURED_IDENTIFICATION_ID")
	private String injuredIdentificationId;
	
	@Column (name = "INS_ID")
	private String insID;
	
	@Column (name = "SCRIPT_NAME")
	private String scriptName;
	
	@Column (name = "NOTIFICATION")
	private String notification;

	public String getVehicleSequenceLink() {
		return vehicleSequenceLink;
	}

	public void setVehicleSequenceLink(String vehicleSequenceLink) {
		this.vehicleSequenceLink = vehicleSequenceLink;
	}

	@Column (name = "VEHICLE_SEQUENCE_LINK")
	private String vehicleSequenceLink;
	public String getDtId() {
		return dtId;
	}

	public void setDtId(String dtId) {
		this.dtId = dtId;
	}

	public String getInjuredId() {
		return injuredId;
	}

	public void setInjuredId(String injuredId) {
		this.injuredId = injuredId;
	}

	public String getInjuredNotificationId() {
		return injuredNotificationId;
	}

	public void setInjuredNotificationId(String injuredNotificationId) {
		this.injuredNotificationId = injuredNotificationId;
	}

	public String getInjuredSeq() {
		return injuredSeq;
	}

	public void setInjuredSeq(String injuredSeq) {
		this.injuredSeq = injuredSeq;
	} 

	public String getBodilyLastName() {
		return bodilyLastName;
	}

	public void setBodilyLastName(String bodilyLastName) {
		this.bodilyLastName = bodilyLastName;
	}

	public String getBodilyFirstName() {
		return bodilyFirstName;
	}

	public void setBodilyFirstName(String bodilyFirstName) {
		this.bodilyFirstName = bodilyFirstName;
	}

	public String getInjuredFather() {
		return injuredFather;
	}

	public void setInjuredFather(String injuredFather) {
		this.injuredFather = injuredFather;
	}

	public String getInjuredGender() {
		return injuredGender;
	}

	public void setInjuredGender(String injuredGender) {
		this.injuredGender = injuredGender;
	}

	public String getInjuredPlace() {
		return injuredPlace;
	}

	public void setInjuredPlace(String injuredPlace) {
		this.injuredPlace = injuredPlace;
	}

	public String getBodilyMobileNumber() {
		return bodilyMobileNumber;
	}

	public void setBodilyMobileNumber(String bodilyMobileNumber) {
		this.bodilyMobileNumber = bodilyMobileNumber;
	}

	public String getInjuredHospitalId() {
		return injuredHospitalId;
	}

	public void setInjuredHospitalId(String injuredHospitalId) {
		this.injuredHospitalId = injuredHospitalId;
	}

	public String getBodilyDob() {
		return bodilyDob;
	}

	public void setBodilyDob(String bodilyDob) {
		this.bodilyDob = bodilyDob;
	}

	public String getInjuredIdentificationId() {
		return injuredIdentificationId;
	}

	public void setInjuredIdentificationId(String injuredIdentificationId) {
		this.injuredIdentificationId = injuredIdentificationId;
	}

	public String getInsID() {
		return insID;
	}

	public void setInsID(String insID) {
		this.insID = insID;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	
}
