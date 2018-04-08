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
@Table(name="m_client_nature")
public class ClientNature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String natureName;
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
	
	public ClientNature() { }

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getNatureName() {
		return natureName;
	}

	public void setNatureName(String natureName) {
		this.natureName = natureName;
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

	public ClientNature(int slno, String natureName, int approveStat, Date createdDate, Date dtAction, int isDeleted) {
		super();
		this.slno = slno;
		this.natureName = natureName;
		this.approveStat = approveStat;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "ClientNature [slno=" + slno + ", natureName=" + natureName + ", approveStat=" + approveStat
				+ ", createdDate=" + createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}
	
}
