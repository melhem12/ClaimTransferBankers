package com.claimTransfer.request;

import io.swagger.annotations.ApiModelProperty;

public class ClaimTransferVehicleRequest {

	@ApiModelProperty(position = 1)
	private String ownerFamilyName;

	@ApiModelProperty(position = 2)
	private String ownerMiddleName;

	@ApiModelProperty(position = 3)
	private String ownerFirstName;

	@ApiModelProperty(position = 4)
	private String driverFamilyName;

	@ApiModelProperty(position = 5)
	private String driverMiddleName;
	
	@ApiModelProperty(position = 6)
	private String driverFirstName;

	@ApiModelProperty(position = 7)
	private String driverPhone;

	@ApiModelProperty(position = 8)
	private String driverGender;

	@ApiModelProperty(position = 9)
	private String driverDob;
	
	@ApiModelProperty(position = 10)
	private String drivingLicenseNumber;
	
	@ApiModelProperty(position = 11)
	private String drivingLicenseExpiryDate;
	
	@ApiModelProperty(position = 12)
	private String drivingLicenseType;
	
	@ApiModelProperty(position = 13)
	private String drivingLicenseInceptionDate;

	@ApiModelProperty(position = 14)
	private String makeDescription;

	@ApiModelProperty(position = 16)
	private String modelDescription;

	@ApiModelProperty(position = 17)
	private String vehicleYear;

	@ApiModelProperty(position = 18)
	private String platePrefix;

	@ApiModelProperty(position = 19)
	private String plateNumber;

	@ApiModelProperty(position = 20)
	private String tpCompanyCode;

	@ApiModelProperty(position = 21)
	private String tpCompanyName;

	@ApiModelProperty(position = 22)
	private String tpPolicyNumber;

	@ApiModelProperty(position = 23)
	private String tpPolEffective;

	@ApiModelProperty(position = 24)
	private String tpPolExpiry;
	
	

	public String getTpPolicyNumber() {
		return tpPolicyNumber;
	}

	public void setTpPolicyNumber(String tpPolicyNumber) {
		this.tpPolicyNumber = tpPolicyNumber;
	}

	public String getTpPolEffective() {
		return tpPolEffective;
	}

	public void setTpPolEffective(String tpPolEffective) {
		this.tpPolEffective = tpPolEffective;
	}

	public String getTpPolExpiry() {
		return tpPolExpiry;
	}

	public void setTpPolExpiry(String tpPolExpiry) {
		this.tpPolExpiry = tpPolExpiry;
	}

	public String getOwnerFamilyName() {
		return ownerFamilyName;
	}

	public void setOwnerFamilyName(String ownerFamilyName) {
		this.ownerFamilyName = ownerFamilyName;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getDriverFamilyName() {
		return driverFamilyName;
	}

	public void setDriverFamilyName(String driverFamilyName) {
		this.driverFamilyName = driverFamilyName;
	}

	public String getDriverFirstName() {
		return driverFirstName;
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getMakeDescription() {
		return makeDescription;
	}

	public void setMakeDescription(String makeDescription) {
		this.makeDescription = makeDescription;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getTpCompanyCode() {
		return tpCompanyCode;
	}

	public void setTpCompanyCode(String tpCompanyCode) {
		this.tpCompanyCode = tpCompanyCode;
	}

	public String getTpCompanyName() {
		return tpCompanyName;
	}

	public void setTpCompanyName(String tpCompanyName) {
		this.tpCompanyName = tpCompanyName;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	public String getDriverDob() {
		return driverDob;
	}

	public void setDriverDob(String driverDob) {
		this.driverDob = driverDob;
	}

	public String getPlatePrefix() {
		return platePrefix;
	}

	public void setPlatePrefix(String platePrefix) {
		this.platePrefix = platePrefix;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getOwnerMiddleName() {
		return ownerMiddleName;
	}

	public void setOwnerMiddleName(String ownerMiddleName) {
		this.ownerMiddleName = ownerMiddleName;
	}

	public String getDriverMiddleName() {
		return driverMiddleName;
	}

	public void setDriverMiddleName(String driverMiddleName) {
		this.driverMiddleName = driverMiddleName;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getDrivingLicenseExpiryDate() {
		return drivingLicenseExpiryDate;
	}

	public void setDrivingLicenseExpiryDate(String drivingLicenseExpiryDate) {
		this.drivingLicenseExpiryDate = drivingLicenseExpiryDate;
	}

	public String getDrivingLicenseType() {
		return drivingLicenseType;
	}

	public void setDrivingLicenseType(String drivingLicenseType) {
		this.drivingLicenseType = drivingLicenseType;
	}

	public String getDrivingLicenseInceptionDate() {
		return drivingLicenseInceptionDate;
	}

	public void setDrivingLicenseInceptionDate(String drivingLicenseInceptionDate) {
		this.drivingLicenseInceptionDate = drivingLicenseInceptionDate;
	}
	
	

}