package com.claimTransfer.response;

import com.claimTransfer.request.ClaimTransferRequest;

public class ClaimsResponse {
  private String responseDesc ;
  private String claimNO ;
  private ClaimTransferRequest claims;

  public String getResponseDesc() {
    return responseDesc;
  }

  public void setResponseDesc(String responseDesc) {
    this.responseDesc = responseDesc;
  }

  public String getClaimNO() {
    return claimNO;
  }

  public void setClaimNO(String claimNO) {
    this.claimNO = claimNO;
  }

  public ClaimTransferRequest getClaims() {
    return claims;
  }

  public void setClaims(ClaimTransferRequest claims) {
    this.claims = claims;
  }
}
