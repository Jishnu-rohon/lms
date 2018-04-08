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
@Table(name="m_gender")
public class Gender {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private Integer approveStat;
	private String genderName;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	

	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer isDeleted;

	Gender() {
		
	}

	public int getSlno() {
		return slno;
	}


	public void setSlno(int slno) {
		this.slno = slno;
	}


	public Integer getApproveStat() {
		return approveStat;
	}


	public void setApproveStat(Integer approveStat) {
		this.approveStat = approveStat;
	}


	public String getGenderName() {
		return genderName;
	}


	public void setGenderName(String genderName) {
		this.genderName = genderName;
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
		return "Gender [slno=" + slno + ", approveStat=" + approveStat + ", genderName=" + genderName + ", createdDate="
				+ createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}


	public Gender(int slno, Integer approveStat, String genderName, Date createdDate, Date dtAction, Integer isDeleted) {
		super();
		this.slno = slno;
		this.approveStat = approveStat;
		this.genderName = genderName;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}
	
}
