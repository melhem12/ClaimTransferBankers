package com.claimTransfer.request;

import java.util.List;

public class Claims {
    private List<ClaimTransferRequest> claims ;

    public List<ClaimTransferRequest> getClaims() {
        return claims;
    }

    public void setClaims(List<ClaimTransferRequest> claims) {
        this.claims = claims;
    }
}
