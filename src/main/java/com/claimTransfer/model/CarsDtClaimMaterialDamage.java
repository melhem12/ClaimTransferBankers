package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS_DT_CLAIM_MATERIAL_DAMAGE")
public class CarsDtClaimMaterialDamage {
	
	@Id
	@Column(name = "DT_ID")
	private String dtId;
	
	@Column(name = "MAT_DAMAGE_OWNER_NAME")
	private String materialDamageOwnerName;
	
	@Column(name = "MAT_DAMAGE_OWNER_PHONE")
	private String materialDamageOwnerPhone;
	
	@Column(name = "MAT_DAMAGE_MATERIAL_TYPE_DESC")
	private String materialDamageMaterialTypeDesc;
	
	@Column(name = "MAT_DAMAGE_SEQUENCE")
	private String materialDamageSequence;



	@Column(name = "MAT_VEHICLE_SEQUENCE_LINK")
	private String materialDamageSequenceLink;

	public String getDtId() {
		return dtId;
	}


	public String getMaterialDamageSequenceLink() {
		return materialDamageSequenceLink;
	}

	public void setMaterialDamageSequenceLink(String materialDamageSequenceLink) {
		this.materialDamageSequenceLink = materialDamageSequenceLink;
	}
	public void setDtId(String dtId) {
		this.dtId = dtId;
	}

	public String getMaterialDamageOwnerName() {
		return materialDamageOwnerName;
	}

	public void setMaterialDamageOwnerName(String materialDamageOwnerName) {
		this.materialDamageOwnerName = materialDamageOwnerName;
	}

	public String getMaterialDamageOwnerPhone() {
		return materialDamageOwnerPhone;
	}

	public void setMaterialDamageOwnerPhone(String materialDamageOwnerPhone) {
		this.materialDamageOwnerPhone = materialDamageOwnerPhone;
	}

	public String getMaterialDamageMaterialTypeDesc() {
		return materialDamageMaterialTypeDesc;
	}

	public void setMaterialDamageMaterialTypeDesc(String materialDamageMaterialTypeDesc) {
		this.materialDamageMaterialTypeDesc = materialDamageMaterialTypeDesc;
	}

	public String getMaterialDamageSequence() {
		return materialDamageSequence;
	}

	public void setMaterialDamageSequence(String materialDamageSequence) {
		this.materialDamageSequence = materialDamageSequence;
	}

	@Override
	public String toString() {
		return "CarsDtClaimMaterialDamage{" +
				"dtId='" + dtId + '\'' +
				", materialDamageOwnerName='" + materialDamageOwnerName + '\'' +
				", materialDamageOwnerPhone='" + materialDamageOwnerPhone + '\'' +
				", materialDamageMaterialTypeDesc='" + materialDamageMaterialTypeDesc + '\'' +
				", materialDamageSequence='" + materialDamageSequence + '\'' +
				", materialDamageSequenceLink='" + materialDamageSequenceLink + '\'' +
				'}';
	}
}
