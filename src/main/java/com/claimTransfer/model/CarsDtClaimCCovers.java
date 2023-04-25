package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS_DT_CLAIM_C_COVERS")
public class CarsDtClaimCCovers {
	
	@Id
	@Column(name = "DT_ID")
	private String dtId;
	
	@Column(name = "SEQUENCE")
	private String sequence;
	
	@Column(name = "COVER_CODE")
	private String coverCode;
	
	@Column(name = "RESERVE_AMOUNT")
	private String reserveAmount;
	
	@Column(name = "CURRENCY")
	private String Currency;
	
	@Column(name = "RECOVERY_RESERVE_AMOUNT")
	private String recoveryReserveAmount;
	
	@Column(name = "SET_TYPE")
	private String setType;

	@Column(name = "PAYEE_PROFILE_TYPE")
	private String payeeProfileType ;


	@Column(name = "PAYEE_PROFILE_CODE")
	private String payeeProfileCode ;



	@Column(name = "PAYEE_ASSESSMENT_TYPE")
	private String payeeAssessmentType ;

	@Column(name = "NOTIFICATION_SEQ")
	private String notificationSeq ;

	public String getNotificationSeq() {
		return notificationSeq;
	}

	public void setNotificationSeq(String notificationSeq) {
		this.notificationSeq = notificationSeq;
	}

	public String getPayeeProfileCode() {
		return payeeProfileCode;
	}

	public void setPayeeProfileCode(String payeeProfileCode) {
		this.payeeProfileCode = payeeProfileCode;
	}

	public String getPayeeAssessmentType() {
		return payeeAssessmentType;
	}

	public void setPayeeAssessmentType(String payeeAssessmentType) {
		this.payeeAssessmentType = payeeAssessmentType;
	}

	public String getPayeeProfileType() {
		return payeeProfileType;
	}

	public void setPayeeProfileType(String payeeProfileType) {
		this.payeeProfileType = payeeProfileType;
	}

	public String getDtId() {
		return dtId;
	}

	public void setDtId(String dtId) {
		this.dtId = dtId;
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

	public String getSetType() {
		return setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	@Override
	public String toString() {
		return "CarsDtClaimCCovers{" +
				"dtId='" + dtId + '\'' +
				", sequence='" + sequence + '\'' +
				", coverCode='" + coverCode + '\'' +
				", reserveAmount='" + reserveAmount + '\'' +
				", Currency='" + Currency + '\'' +
				", recoveryReserveAmount='" + recoveryReserveAmount + '\'' +
				", setType='" + setType + '\'' +
				", payeeProfileType='" + payeeProfileType + '\'' +
				", payeeProfileCode='" + payeeProfileCode + '\'' +
				", payeeAssessmentType='" + payeeAssessmentType + '\'' +
				", notificationSeq='" + notificationSeq + '\'' +
				'}';
	}
}
