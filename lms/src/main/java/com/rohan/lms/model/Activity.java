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
@Table(name="tbl_activity")
public class Activity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private int userSlno;//created by
	private int leadSlno;
	private int leadStatusSlno;
	private int activityTypeSlno;
	private String activitySubject;
	private String activityDesc;
	private String fileUpload;
	private int approvStat;
	private int companySlno;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	
	private int isDeleted;
	
	public Activity() {
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public int getUserSlno() {
		return userSlno;
	}

	public void setUserSlno(int userSlno) {
		this.userSlno = userSlno;
	}

	public int getLeadSlno() {
		return leadSlno;
	}

	public void setLeadSlno(int leadSlno) {
		this.leadSlno = leadSlno;
	}

	public int getActivityTypeSlno() {
		return activityTypeSlno;
	}

	public void setActivityTypeSlno(int activityTypeSlno) {
		this.activityTypeSlno = activityTypeSlno;
	}

	public String getActivitySubject() {
		return activitySubject;
	}

	public void setActivitySubject(String activitySubject) {
		this.activitySubject = activitySubject;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public int getLeadStatusSlno() {
		return leadStatusSlno;
	}

	public void setLeadStatusSlno(int leadStatusSlno) {
		this.leadStatusSlno = leadStatusSlno;
	}

	public int getApprovStat() {
		return approvStat;
	}

	public void setApprovStat(int approvStat) {
		this.approvStat = approvStat;
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
		return "Activity [slno=" + slno + ", userSlno=" + userSlno + ", leadSlno=" + leadSlno + ", activityTypeSlno="
				+ activityTypeSlno + ", activitySubject=" + activitySubject + ", activityDesc=" + activityDesc
				+ ", fileUpload=" + fileUpload + ", leadStatusSlno=" + leadStatusSlno + ", approvStat=" + approvStat
				+ ", companySlno=" + companySlno + ", createdDate=" + createdDate + ", dtAction=" + dtAction
				+ ", isDeleted=" + isDeleted + "]";
	}

	public Activity(int slno, int userSlno, int leadSlno, int activityTypeSlno, String activitySubject,
			String activityDesc, String fileUpload, int leadStatusSlno, int approvStat, int companySlno,
			Date createdDate, Date dtAction, int isDeleted) {
		super();
		this.slno = slno;
		this.userSlno = userSlno;
		this.leadSlno = leadSlno;
		this.activityTypeSlno = activityTypeSlno;
		this.activitySubject = activitySubject;
		this.activityDesc = activityDesc;
		this.fileUpload = fileUpload;
		this.leadStatusSlno = leadStatusSlno;
		this.approvStat = approvStat;
		this.companySlno = companySlno;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
