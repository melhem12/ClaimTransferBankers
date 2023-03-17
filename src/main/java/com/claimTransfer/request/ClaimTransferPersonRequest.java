package com.claimTransfer.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaimTransferPersonRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1)
	private String sequence;
	
	@ApiModelProperty(position = 2)
	private String vehicleSequence;
	
	@ApiModelProperty(position = 3)
	private String responsibility;
	
	@ApiModelProperty(position = 4)
	private ClaimTransferVehicleRequest claimTransferVehicleRequest;
	
	
	@ApiModelProperty(position = 5)
	private ClaimTransferBodilyRequest claimTransferBodilyRequest;
	
	@ApiModelProperty(position = 6)
	private ClaimTransferMaterialRequest claimTransferMaterialRequest;
	
	@ApiModelProperty(position = 7)
	private List<ClaimTransferCoverRequest> claimTransferCoverRequestList;
	
//	private String ownerFamilyName;
//	
//	private String ownerFirstName;
//	
//	private String driverFamilyName;
//	
//	private String driverFirstName;
//	
//	private String driverPhone;
//	
//	private String gender;
//	
//	private String dob;
//	
//	private String makeCode;
//	
//	private String modelCode;
//	
//	private String vehicleYear;
//	
//	private String plate;
//	
//	private String tpCompanyCode;
//	
//	private String tpCompanyName;
	
//	private String responsability;


	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	public List<ClaimTransferCoverRequest> getClaimTransferCoverRequestList() {
		return claimTransferCoverRequestList;
	}

	public void setClaimTransferCoverRequestList(List<ClaimTransferCoverRequest> claimTransferCoverRequestList) {
		this.claimTransferCoverRequestList = claimTransferCoverRequestList;
	}

	public String getVehicleSequence() {
		return vehicleSequence;
	}

	public void setVehicleSequence(String vehicleSequence) {
		this.vehicleSequence = vehicleSequence;
	}

//	public String getOwnerFamilyName() {
//		return ownerFamilyName;
//	}
//
//	public void setOwnerFamilyName(String ownerFamilyName) {
//		this.ownerFamilyName = ownerFamilyName;
//	}
//
//	public String getOwnerFirstName() {
//		return ownerFirstName;
//	}
//
//	public void setOwnerFirstName(String ownerFirstName) {
//		this.ownerFirstName = ownerFirstName;
//	}
//
//	public String getDriverFamilyName() {
//		return driverFamilyName;
//	}
//
//	public void setDriverFamilyName(String driverFamilyName) {
//		this.driverFamilyName = driverFamilyName;
//	}
//
//	public String getDriverFirstName() {
//		return driverFirstName;
//	}
//
//	public void setDriverFirstName(String driverFirstName) {
//		this.driverFirstName = driverFirstName;
//	}
//
//	public String getDriverPhone() {
//		return driverPhone;
//	}
//
//	public void setDriverPhone(String driverPhone) {
//		this.driverPhone = driverPhone;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getDob() {
//		return dob;
//	}
//
//	public void setDob(String dob) {
//		this.dob = dob;
//	}
//
//	public String getMakeCode() {
//		return makeCode;
//	}
//
//	public void setMakeCode(String makeCode) {
//		this.makeCode = makeCode;
//	}
//
//	public String getModelCode() {
//		return modelCode;
//	}
//
//	public void setModelCode(String modelCode) {
//		this.modelCode = modelCode;
//	}
//
//	public String getVehicleYear() {
//		return vehicleYear;
//	}
//
//	public void setVehicleYear(String vehicleYear) {
//		this.vehicleYear = vehicleYear;
//	}
//
//	public String getPlate() {
//		return plate;
//	}
//
//	public void setPlate(String plate) {
//		this.plate = plate;
//	}
//
//	public String getTpCompanyCode() {
//		return tpCompanyCode;
//	}
//
//	public void setTpCompanyCode(String tpCompanyCode) {
//		this.tpCompanyCode = tpCompanyCode;
//	}
//
//	public String getTpCompanyName() {
//		return tpCompanyName;
//	}
//
//	public void setTpCompanyName(String tpCompanyName) {
//		this.tpCompanyName = tpCompanyName;
//	}


	

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public ClaimTransferVehicleRequest getClaimTransferVehicleRequest() {
		return claimTransferVehicleRequest;
	}

	public void setClaimTransferVehicleRequest(ClaimTransferVehicleRequest claimTransferVehicleRequest) {
		this.claimTransferVehicleRequest = claimTransferVehicleRequest;
	}

	public ClaimTransferBodilyRequest getClaimTransferBodilyRequest() {
		return claimTransferBodilyRequest;
	}

	public void setClaimTransferBodilyRequest(ClaimTransferBodilyRequest claimTransferBodilyRequest) {
		this.claimTransferBodilyRequest = claimTransferBodilyRequest;
	}

	public ClaimTransferMaterialRequest getClaimTransferMaterialRequest() {
		return claimTransferMaterialRequest;
	}

	public void setClaimTransferMaterialRequest(ClaimTransferMaterialRequest claimTransferMaterialRequest) {
		this.claimTransferMaterialRequest = claimTransferMaterialRequest;
	}

}