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

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="m_l_source")
public class LeadSource {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	private String sourceName;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_action")
	private Date dtAction;
	private Integer approveStat;
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer isDeleted = 0;
	
	public LeadSource() { }

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Date getDtAction() {
		return dtAction;
	}

	public void setDtAction(Date dtAction) {
		this.dtAction = dtAction;
	}

	public Integer getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(Integer approveStat) {
		this.approveStat = approveStat;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "LeadSource [slno=" + slno + ", sourceName=" + sourceName + ", dtAction=" + dtAction + ", approveStat="
				+ approveStat + ", isDeleted=" + isDeleted + "]";
	}

	public LeadSource(Integer slno, String sourceName, Date dtAction, Integer approveStat, Integer isDeleted) {
		super();
		this.slno = slno;
		this.sourceName = sourceName;
		this.dtAction = dtAction;
		this.approveStat = approveStat;
		this.isDeleted = isDeleted;
	}

}
