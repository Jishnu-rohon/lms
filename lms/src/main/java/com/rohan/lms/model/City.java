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
@Table(name="m_city")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String cityName;
	private int stateSlno;
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
	
	public City() {
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getStateSlno() {
		return stateSlno;
	}

	public void setStateSlno(int stateSlno) {
		this.stateSlno = stateSlno;
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
		return "City [slno=" + slno + ", cityName=" + cityName + ", stateSlno=" + stateSlno + ", approveStat="
				+ approveStat + ", createdDate=" + createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted
				+ "]";
	}

	public City(int slno, String cityName, int stateSlno, int approveStat, Date createdDate, Date dtAction,
			int isDeleted) {
		super();
		this.slno = slno;
		this.cityName = cityName;
		this.stateSlno = stateSlno;
		this.approveStat = approveStat;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}
	
}
