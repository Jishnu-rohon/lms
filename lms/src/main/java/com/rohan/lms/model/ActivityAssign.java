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
@Table(name="tbl_activity_assign")
public class ActivityAssign {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private int assignedBySlno;
	private int assignedToSlno;
	private int activitySlno;
	private int activityStatusSlno;
	private Date actFrom;
	private Date actTo;
	private int companySlno;
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
	
	public ActivityAssign() {
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public int getAssignedBySlno() {
		return assignedBySlno;
	}

	public void setAssignedBySlno(int assignedBySlno) {
		this.assignedBySlno = assignedBySlno;
	}

	public int getAssignedToSlno() {
		return assignedToSlno;
	}

	public void setAssignedToSlno(int assignedToSlno) {
		this.assignedToSlno = assignedToSlno;
	}

	public int getActivitySlno() {
		return activitySlno;
	}

	public void setActivitySlno(int activitySlno) {
		this.activitySlno = activitySlno;
	}

	public int getActivityStatusSlno() {
		return activityStatusSlno;
	}

	public void setActivityStatusSlno(int activityStatusSlno) {
		this.activityStatusSlno = activityStatusSlno;
	}

	public Date getActFrom() {
		return actFrom;
	}

	public void setActFrom(Date actFrom) {
		this.actFrom = actFrom;
	}

	public Date getActTo() {
		return actTo;
	}

	public void setActTo(Date actTo) {
		this.actTo = actTo;
	}

	public int getCompanySlno() {
		return companySlno;
	}

	public void setCompanySlno(int companySlno) {
		this.companySlno = companySlno;
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
		return "ActivityAssign [slno=" + slno + ", assignedBySlno=" + assignedBySlno + ", assignedToSlno="
				+ assignedToSlno + ", activitySlno=" + activitySlno + ", activityStatusSlno=" + activityStatusSlno
				+ ", actFrom=" + actFrom + ", actTo=" + actTo + ", companySlno=" + companySlno + ", createdDate="
				+ createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}

	public ActivityAssign(int slno, int assignedBySlno, int assignedToSlno, int activitySlno, int activityStatusSlno,
			Date actFrom, Date actTo, int companySlno, Date createdDate, Date dtAction, int isDeleted) {
		super();
		this.slno = slno;
		this.assignedBySlno = assignedBySlno;
		this.assignedToSlno = assignedToSlno;
		this.activitySlno = activitySlno;
		this.activityStatusSlno = activityStatusSlno;
		this.actFrom = actFrom;
		this.actTo = actTo;
		this.companySlno = companySlno;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
