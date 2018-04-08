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
@Table(name="m_kyc_type")
public class KycType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	private String typeName;
	private Integer approveStat;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer isDeleted;
	
	public KycType() { }

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(Integer approveStat) {
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "KycType [slno=" + slno + ", typeName=" + typeName + ", approveStat=" + approveStat + ", createdDate="
				+ createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}

	public KycType(Integer slno, String typeName, Integer approveStat, Date createdDate, Date dtAction,
			Integer isDeleted) {
		super();
		this.slno = slno;
		this.typeName = typeName;
		this.approveStat = approveStat;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}
	
}
