package com.claimTransfer.request;

import java.io.Serializable;
import java.util.List;

public class ClaimTransferListRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ClaimTransferRequest> claimTransferRequestList;

	public List<ClaimTransferRequest> getClaimTransferRequestList() {
		return claimTransferRequestList;
	}

	public void setClaimTransferRequestList(List<ClaimTransferRequest> claimTransferRequestList) {
		this.claimTransferRequestList = claimTransferRequestList;
	}

}