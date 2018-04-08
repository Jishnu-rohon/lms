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
@Table(name="m_state")
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String stateName;
	private int countrySlno;
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
	
	public State() {
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getCountrySlno() {
		return countrySlno;
	}

	public void setCountrySlno(int countrySlno) {
		this.countrySlno = countrySlno;
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
		return "State [slno=" + slno + ", stateName=" + stateName + ", countrySlno=" + countrySlno + ", approveStat="
				+ approveStat + ", createdDate=" + createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted
				+ "]";
	}

	public State(int slno, String stateName, int countrySlno, int approveStat, Date createdDate, Date dtAction,
			int isDeleted) {
		super();
		this.slno = slno;
		this.stateName = stateName;
		this.countrySlno = countrySlno;
		this.approveStat = approveStat;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}
	
}
