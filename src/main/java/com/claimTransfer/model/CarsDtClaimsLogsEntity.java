package com.claimTransfer.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "CARS_DT_CLAIMS_LOGS", schema = "PORTAL")
@Getter
@Setter
@ToString
public class CarsDtClaimsLogsEntity {
    @Id
    @Column(name = "CARS_DT_CLAIMS_LOGS_ID", length = 360)
    private String carsDtClaimsLogsId;


    public CarsDtClaimsLogsEntity() {
        // Generate a random UUID and set it as the value of carsDtClaimsLogsId
        this.carsDtClaimsLogsId = UUID.randomUUID().toString();
    }


    @Column(name = "NOTIFICATION", length = 60)
    private String notification;

    @Column(name = "SCRIPT_NAME", length = 60)
    private String scriptName;

    @Column(name = "INS_ID", length = 60)
    private String insId;

    @Column(name = "SYS_UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date sysUpdatedDate;

    @Column(name = "SYS_CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date sysCreatedDate;

    @Column(name = "SYS_UPDATED_BY", length = 60)
    private String sysUpdatedBy;

    @Column(name = "SYS_VERSION_NUMBER")
    private Long sysVersionNumber;

    @Column(name = "SYS_CREATED_BY", length = 36)
    private String sysCreatedBy;

    @Column(name = "CARS_DT_CLAIMS_RESP_MSG", length = 4000)
    private String carsDtClaimsRespMsg;

    @Column(name = "CARS_DT_CLAIMS_RESP_DESC", length = 4000)
    private String carsDtClaimsRespDesc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarsDtClaimsLogsEntity that = (CarsDtClaimsLogsEntity) o;
        return carsDtClaimsLogsId != null && Objects.equals(carsDtClaimsLogsId, that.carsDtClaimsLogsId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
