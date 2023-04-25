package com.claimTransfer.request;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ClaimTransferCoverRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(position = 1)
	private String sequence;
	
	@ApiModelProperty(position = 2)
	private String coverCode;
	
	@ApiModelProperty(position = 3)
	private String subcover;
	
	@ApiModelProperty(position = 4)
	private String subcoverCode;
	
	@ApiModelProperty(position = 5)
	private String  riskType;
	@ApiModelProperty(position = 6)

	private  String assessmentType;
	@ApiModelProperty(position = 7)
	private String  profileType;


	@ApiModelProperty(position = 8)
	private String  profileCode;




	@ApiModelProperty(position = 9)
	private String reserveCurrency;
	
	@ApiModelProperty(position = 10)
	private String reserveAmount;
	
	@ApiModelProperty(position = 11)
	private String recoveryReserveAmount;
		
	@ApiModelProperty(position = 12)
	private List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList;

	public String getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getCoverCode() {
		return coverCode;
	}

	public void setCoverCode(String coverCode) {
		this.coverCode = coverCode;
	}

	public String getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(String reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public String getRecoveryReserveAmount() {
		return recoveryReserveAmount;
	}

	public void setRecoveryReserveAmount(String recoveryReserveAmount) {
		this.recoveryReserveAmount = recoveryReserveAmount;
	}

	public List<ClaimTransferSettlementRequest> getClaimTransferSettlementRequestList() {
		return claimTransferSettlementRequestList;
	}

	public void setClaimTransferSettlementRequestList(List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList) {
		this.claimTransferSettlementRequestList = claimTransferSettlementRequestList;
	}

	public String getSubcover() {
		return subcover;
	}

	public void setSubcover(String subcover) {
		this.subcover = subcover;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public String getSubcoverCode() {
		return subcoverCode;
	}

	public void setSubcoverCode(String subcoverCode) {
		this.subcoverCode = subcoverCode;
	}

	public String getReserveCurrency() {
		return reserveCurrency;
	}

	public void setReserveCurrency(String reserveCurrency) {
		this.reserveCurrency = reserveCurrency;
	}

	@Override
	public String toString() {
		return "ClaimTransferCoverRequest{" +
				"sequence='" + sequence + '\'' +
				", coverCode='" + coverCode + '\'' +
				", subcover='" + subcover + '\'' +
				", subcoverCode='" + subcoverCode + '\'' +
				", riskType='" + riskType + '\'' +
				", assessmentType='" + assessmentType + '\'' +
				", profileType='" + profileType + '\'' +
				", profileCode='" + profileCode + '\'' +
				", reserveCurrency='" + reserveCurrency + '\'' +
				", reserveAmount='" + reserveAmount + '\'' +
				", recoveryReserveAmount='" + recoveryReserveAmount + '\'' +
				", claimTransferSettlementRequestList=" + claimTransferSettlementRequestList +
				'}';
	}
}