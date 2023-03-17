package com.claimTransfer.request;

import java.io.Serializable;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ClaimTransferRequest implements Serializable {

	@Override
	public String toString() {
		return "ClaimTransferRequest [claimTransferId=" + claimTransferId + ", claimTransferNotification="
				+ claimTransferNotification + ", claimTransferNumber=" + claimTransferNumber + ", policyId=" + policyId
				+ ", vehicleCertificate=" + vehicleCertificate + ", accidentDate=" + accidentDate + ", reportedDate="
				+ reportedDate + ", statusCode=" + statusCode + ", statusDate=" + statusDate + ", accidentLongitude="
				+ accidentLongitude + ", accidentLatitude=" + accidentLatitude + ", accidentLocation_Desc="
				+ accidentLocation_Desc + ", claimReason=" + claimReason + ", claimTransferPersonRequestList="
				+ claimTransferPersonRequestList + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(position = 1)
	private String claimTransferId;

	@ApiModelProperty(position = 2)
	private String claimTransferNotification;

	@ApiModelProperty(position = 3)
	private String claimRelatedNotification;

	@ApiModelProperty(position = 4)
	private String claimTransferNumber;

	@ApiModelProperty(position = 5)
	private String policyId;

	@ApiModelProperty(position = 6)
	private String policyNumber;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	@ApiModelProperty(position = 7)
	private String certifId ;

	@ApiModelProperty(position = 8)
	private String vehicleCertificate;

	@ApiModelProperty(position = 9)
	private String accidentDate;

	@ApiModelProperty(position = 10)
	private String accidentTime;

	@ApiModelProperty(position = 11)
	private String reportedDate;

	@ApiModelProperty(position = 12)
	private String reportedTime;

	@ApiModelProperty(position = 13)
	private String statusCode;

	@ApiModelProperty(position = 14)
	private String statusDescription;

	@ApiModelProperty(position = 15)
	private String statusDate;

	@ApiModelProperty(position = 16)
	private String accidentLongitude;

	@ApiModelProperty(position = 17)
	private String accidentLatitude;

	@ApiModelProperty(position = 18)
	private String accidentLocation_Desc;

	@ApiModelProperty(position = 19)
	private String claimReason;

	@ApiModelProperty(position = 20)
	private String totalReserve;

	@ApiModelProperty(position = 21)
	private String coverCode;

	@ApiModelProperty(position = 22)
	private String riskType;

	@ApiModelProperty(position = 23)
	private String reserveCurrency;

	@ApiModelProperty(position = 24)
	private String totalPaid;

	@ApiModelProperty(position = 25)
	private String totalOS;
	
	@ApiModelProperty(position = 26)
	private String reserveDifference;

	@ApiModelProperty(position = 27)
	private String expertCode;

	@ApiModelProperty(position = 28)
	private String expertName;

//	@ApiModelProperty(position = 21)
//	private String TotalOS;
@ApiModelProperty(position = 29)
private String accidentLocation_Caza;


	@ApiModelProperty(position = 30)
	private String accidentLocation_Mohafaza;



	@ApiModelProperty(position = 23)
	private List<ClaimTransferPersonRequest> claimTransferPersonRequestList;

	public String getCertifId() {
		return certifId;
	}

	public void setCertifId(String certifId) {
		this.certifId = certifId;
	}

	public String getAccidentLongitude() {
		return accidentLongitude;
	}

	public void setAccidentLongitude(String accidentLongitude) {
		this.accidentLongitude = accidentLongitude;
	}

	public String getAccidentLatitude() {
		return accidentLatitude;
	}

	public void setAccidentLatitude(String accidentLatitude) {
		this.accidentLatitude = accidentLatitude;
	}

	public String getAccidentLocation_Desc() {
		return accidentLocation_Desc;
	}

	public void setAccidentLocation_Desc(String accidentLocation_Desc) {
		this.accidentLocation_Desc = accidentLocation_Desc;
	}

	public String getAccidentLocation_Caza() {
		return accidentLocation_Caza;
	}

	public void setAccidentLocation_Caza(String accidentLocation_Caza) {
		this.accidentLocation_Caza = accidentLocation_Caza;
	}

	public String getAccidentLocation_Mohafaza() {
		return accidentLocation_Mohafaza;
	}

	public void setAccidentLocation_Mohafaza(String accidentLocation_Mohafaza) {
		this.accidentLocation_Mohafaza = accidentLocation_Mohafaza;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public List<ClaimTransferPersonRequest> getClaimTransferPersonRequestList() {
		return claimTransferPersonRequestList;
	}

	public void setClaimTransferPersonRequestList(List<ClaimTransferPersonRequest> claimTransferPersonRequestList) {
		this.claimTransferPersonRequestList = claimTransferPersonRequestList;
	}

	public String getClaimTransferId() {
		return claimTransferId;
	}

	public void setClaimTransferId(String claimTransferId) {
		this.claimTransferId = claimTransferId;
	}

	public String getClaimTransferNotification() {
		return claimTransferNotification;
	}

	public void setClaimTransferNotification(String claimTransferNotification) {
		this.claimTransferNotification = claimTransferNotification;
	}

	public String getClaimTransferNumber() {
		return claimTransferNumber;
	}

	public void setClaimTransferNumber(String claimTransferNumber) {
		this.claimTransferNumber = claimTransferNumber;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getVehicleCertificate() {
		return vehicleCertificate;
	}

	public void setVehicleCertificate(String vehicleCertificate) {
		this.vehicleCertificate = vehicleCertificate;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getClaimRelatedNotification() {
		return claimRelatedNotification;
	}

	public void setClaimRelatedNotification(String claimRelatedNotification) {
		this.claimRelatedNotification = claimRelatedNotification;
	}

	public String getTotalReserve() {
		return totalReserve;
	}

	public void setTotalReserve(String totalReserve) {
		this.totalReserve = totalReserve;
	}

	public String getCoverCode() {
		return coverCode;
	}

	public void setCoverCode(String coverCode) {
		this.coverCode = coverCode;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getReserveCurrency() {
		return reserveCurrency;
	}

	public void setReserveCurrency(String reserveCurrency) {
		this.reserveCurrency = reserveCurrency;
	}

	public String getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getTotalOS() {
		return totalOS;
	}

	public void setTotalOS(String totalOS) {
		this.totalOS = totalOS;
	}

	public String getExpertCode() {
		return expertCode;
	}

	public void setExpertCode(String expertCode) {
		this.expertCode = expertCode;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getReserveDifference() {
		return reserveDifference;
	}

	public void setReserveDifference(String reserveDifference) {
		this.reserveDifference = reserveDifference;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getReportedTime() {
		return reportedTime;
	}

	public void setReportedTime(String reportedTime) {
		this.reportedTime = reportedTime;
	}
}
