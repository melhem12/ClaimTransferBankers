package com.claimTransfer.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ClaimTransferBodilyRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1)
	private String bodilyFirstName;
	
	@ApiModelProperty(position = 2)
	private String bodilyMiddleName;
	
	@ApiModelProperty(position = 3)
	private String bodilyLastName;
	
	@ApiModelProperty(position = 4)
	private String bodilyDob;
	
	@ApiModelProperty(position = 5)
	private String bodilyMobileNumber;
	
	@ApiModelProperty(position = 6)
	private String bodilyType;
	@ApiModelProperty(position = 7)
	private String bodilyVehicleSequenceLink;

	public String getBodilyVehicleSequenceLink() {
		return bodilyVehicleSequenceLink;
	}

	public void setBodilyVehicleSequenceLink(String bodilyVehicleSequenceLink) {
		this.bodilyVehicleSequenceLink = bodilyVehicleSequenceLink;
	}
//	@ApiModelProperty(position = 6)
//	private String bodilySequence;

	public String getBodilyFirstName() {
		return bodilyFirstName;
	}

	public void setBodilyFirstName(String bodilyFirstName) {
		this.bodilyFirstName = bodilyFirstName;
	}

	public String getBodilyLastName() {
		return bodilyLastName;
	}

	public void setBodilyLastName(String bodilyLastName) {
		this.bodilyLastName = bodilyLastName;
	}

	public String getBodilyDob() {
		return bodilyDob;
	}

	public void setBodilyDob(String bodilyDob) {
		this.bodilyDob = bodilyDob;
	}

	public String getBodilyMobileNumber() {
		return bodilyMobileNumber;
	}

	public void setBodilyMobileNumber(String bodilyMobileNumber) {
		this.bodilyMobileNumber = bodilyMobileNumber;
	}



	public String getBodilyMiddleName() {
		return bodilyMiddleName;
	}

	public void setBodilyMiddleName(String bodilyMiddleName) {
		this.bodilyMiddleName = bodilyMiddleName;
	}

	public String getBodilyType() {
		return bodilyType;
	}

	public void setBodilyType(String bodilyType) {
		this.bodilyType = bodilyType;
	}


	@Override
	public String toString() {
		return "ClaimTransferBodilyRequest{" +
				"bodilyFirstName='" + bodilyFirstName + '\'' +
				", bodilyMiddleName='" + bodilyMiddleName + '\'' +
				", bodilyLastName='" + bodilyLastName + '\'' +
				", bodilyDob='" + bodilyDob + '\'' +
				", bodilyMobileNumber='" + bodilyMobileNumber + '\'' +
				", bodilyType='" + bodilyType + '\'' +
				", bodilyVehicleSequenceLink='" + bodilyVehicleSequenceLink + '\'' +
				'}';
	}
}
