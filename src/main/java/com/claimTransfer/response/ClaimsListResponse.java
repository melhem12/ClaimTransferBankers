package com.claimTransfer.response;

import java.util.List;

public class ClaimsListResponse {
    private String message;
    private List<ClaimsResponseCustom> claimsResponseList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ClaimsResponseCustom> getClaimsResponseList() {
        return claimsResponseList;
    }

    public void setClaimsResponseList(List<ClaimsResponseCustom> claimsResponseList) {
        this.claimsResponseList = claimsResponseList;
    }
}
