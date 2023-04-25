package com.claimTransfer.request;

import java.io.Serializable;

import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;

public class ClaimTransferSettlementRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1)
	private String transaction;

	@ApiModelProperty(position = 2)
	private String paymentSequence;

	@ApiModelProperty(position = 3)
	private String currency;

	@ApiModelProperty(position = 4)
	private String paidAmount;

	@ApiModelProperty(position = 5)
	private String paymentDate;

	@ApiModelProperty(position = 6)
	private String payeeTypeCode;
	
	@ApiModelProperty(position = 7)
	private String payeeTypeDescription;

	@ApiModelProperty(position = 8)
	private String payeeCode;

	@ApiModelProperty(position = 9)
	private String payeeName;

	@ApiModelProperty(position = 10)
	private String type;

	

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public void setPaymentSequence(String paymentSequence) {
		this.paymentSequence = paymentSequence;
	}

	public String getPaymentSequence() {
		return paymentSequence;
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

	@Override
	public String toString() {
		return "ClaimTransferSettlementRequest{" +
				"transaction='" + transaction + '\'' +
				", paymentSequence='" + paymentSequence + '\'' +
				", currency='" + currency + '\'' +
				", paidAmount='" + paidAmount + '\'' +
				", paymentDate='" + paymentDate + '\'' +
				", payeeTypeCode='" + payeeTypeCode + '\'' +
				", payeeTypeDescription='" + payeeTypeDescription + '\'' +
				", payeeCode='" + payeeCode + '\'' +
				", payeeName='" + payeeName + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}