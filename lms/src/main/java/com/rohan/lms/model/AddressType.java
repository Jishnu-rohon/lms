package com.rohan.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="m_address_type")
public class AddressType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String addressTypeName;
	private int approveStat;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int isDeleted;
	
	public AddressType() { }

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getAddressTypeName() {
		return addressTypeName;
	}

	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
	}

	public int getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(int approveStat) {
		this.approveStat = approveStat;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDtAction() {
		return dtAction;
	}

	public void setDtAction(Date dtAction) {
		this.dtAction = dtAction;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "AddressType [slno=" + slno + ", addressTypeName=" + addressTypeName + ", approveStat=" + approveStat
				+ ", createdDate=" + createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}

	public AddressType(int slno, String addressTypeName, int approveStat, Date createdDate, Date dtAction,
			int isDeleted) {
		super();
		this.slno = slno;
		this.addressTypeName = addressTypeName;
		this.approveStat = approveStat;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
