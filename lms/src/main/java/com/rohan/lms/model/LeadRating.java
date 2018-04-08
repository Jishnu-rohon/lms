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
@Table(name="m_l_rating")
public class LeadRating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	private String ratingName;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_action")
	private Date dtAction;
	private Integer approveStat;
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer isDeleted = 0;
	
	public LeadRating() { }

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
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
		return "LeadRating [slno=" + slno + ", ratingName=" + ratingName + ", dtAction=" + dtAction + ", approveStat="
				+ approveStat + ", isDeleted=" + isDeleted + "]";
	}

	public LeadRating(Integer slno, String ratingName, Date dtAction, Integer approveStat, Integer isDeleted) {
		super();
		this.slno = slno;
		this.ratingName = ratingName;
		this.dtAction = dtAction;
		this.approveStat = approveStat;
		this.isDeleted = isDeleted;
	}

}
