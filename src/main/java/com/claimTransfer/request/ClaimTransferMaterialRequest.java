package com.claimTransfer.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ClaimTransferMaterialRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1)
	private String materialFullName;
	
	@ApiModelProperty(position = 2)
	private String materialMobileNumber;
	
	@ApiModelProperty(position = 3)
	private String materialDescription;



	@ApiModelProperty(position = 4)
	private String matSequenceLink;



	public String getMatSequenceLink() {
		return matSequenceLink;
	}

	public void setMatSequenceLink(String matSequenceLink) {
		this.matSequenceLink = matSequenceLink;
	}

	public String getMaterialFullName() {
		return materialFullName;
	}

	public void setMaterialFullName(String materialFullName) {
		this.materialFullName = materialFullName;
	}

	public String getMaterialMobileNumber() {
		return materialMobileNumber;
	}

	public void setMaterialMobileNumber(String materialMobileNumber) {
		this.materialMobileNumber = materialMobileNumber;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	@Override
	public String toString() {
		return "ClaimTransferMaterialRequest{" +
				"materialFullName='" + materialFullName + '\'' +
				", materialMobileNumber='" + materialMobileNumber + '\'' +
				", materialDescription='" + materialDescription + '\'' +
				", matSequenceLink='" + matSequenceLink + '\'' +
				'}';
	}
}

