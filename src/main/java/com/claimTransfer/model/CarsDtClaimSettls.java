package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS_DT_CLAIM_SETTLS")
public class CarsDtClaimSettls {
	
	@Id
	@Column(name = "DT_ID")
	private String dtId;
	
	@Column(name = "TRANSACTION")
	private String transaction;
	
	@Column(name = "SEQUENCE")
	private String paymentSequence;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "PAID_AMOUNT")
	private String paidAmount;
	
	@Column(name = "PAYMENT_DATE")
	private String paymentDate;
	
//	@Column(name = "PAYEE_TYPE")
//	private String payeeType;
	
	@Column(name = "PAYEE_TYPE")
	private String payeeTypeCode;
	
	@Column(name = "PAYEE_TYPE_DESCRIPTION")
	private String payeeTypeDescription;
	
	
	@Column(name = "PAYEE_CODE")
	private String payeeCode;
	
	@Column(name = "PAYEE_NAME")
	private String payeeName;
	
	@Column(name = "SET_TYPE")
	private String setType;
	
	@Column(name = "RISK_TYPE")
	private String riskType;

	public String getDtId() {
		return dtId;
	}

	public void setDtId(String dtId) {
		this.dtId = dtId;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getPaymentSequence() {
		return paymentSequence;
	}

	public void setPaymentSequence(String paymentSequence) {
		this.paymentSequence = paymentSequence;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}



	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getSetType() {
		return setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getPayeeTypeCode() {
		return payeeTypeCode;
	}

	public void setPayeeTypeCode(String payeeTypeCode) {
		this.payeeTypeCode = payeeTypeCode;
	}

	public String getPayeeTypeDescription() {
		return payeeTypeDescription;
	}

	public void setPayeeTypeDescription(String payeeTypeDescription) {
		this.payeeTypeDescription = payeeTypeDescription;
	}
	
	
}
