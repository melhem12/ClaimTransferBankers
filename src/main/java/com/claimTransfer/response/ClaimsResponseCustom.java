package com.claimTransfer.response;

import com.claimTransfer.request.ClaimTransferRequest;
import io.swagger.annotations.ApiModelProperty;

public class ClaimsResponseCustom {
    @ApiModelProperty(position = 1)

    private String responseDesc ;
    @ApiModelProperty(position = 2)
    private String responseMessage ;
    @ApiModelProperty(position = 3)

    private String claimNO ;
    @ApiModelProperty(position = 4)
    private String claimTransferId;

    @ApiModelProperty(position = 5)
    private String claimTransferNotification;


    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getClaimNO() {
        return claimNO;
    }

    public void setClaimNO(String claimNO) {
        this.claimNO = claimNO;
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
}
