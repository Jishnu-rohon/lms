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
@Table(name="m_license")
public class License {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private int billing_slno;
	private String license_key;
	private Date dt_activation;
	private Date dt_expiry;
	private int approve_stat;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	
	public License() {
		// TODO Auto-generated constructor stub
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public int getBilling_slno() {
		return billing_slno;
	}

	public void setBilling_slno(int billing_slno) {
		this.billing_slno = billing_slno;
	}

	public String getLicense_key() {
		return license_key;
	}

	public void setLicense_key(String license_key) {
		this.license_key = license_key;
	}

	public Date getDt_activation() {
		return dt_activation;
	}

	public void setDt_activation(Date dt_activation) {
		this.dt_activation = dt_activation;
	}

	public Date getDt_expiry() {
		return dt_expiry;
	}

	public void setDt_expiry(Date dt_expiry) {
		this.dt_expiry = dt_expiry;
	}

	public int getApprove_stat() {
		return approve_stat;
	}

	public void setApprove_stat(int approve_stat) {
		this.approve_stat = approve_stat;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getDt_action() {
		return dt_action;
	}

	public void setDt_action(Date dt_action) {
		this.dt_action = dt_action;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "License [slno=" + slno + ", billing_slno=" + billing_slno + ", license_key=" + license_key
				+ ", dt_activation=" + dt_activation + ", dt_expiry=" + dt_expiry + ", approve_stat=" + approve_stat
				+ ", created_date=" + created_date + ", dt_action=" + dt_action + ", is_deleted=" + is_deleted + "]";
	}

	public License(int slno, int billing_slno, String license_key, Date dt_activation, Date dt_expiry, int approve_stat,
			Date created_date, Date dt_action, int is_deleted) {
		super();
		this.slno = slno;
		this.billing_slno = billing_slno;
		this.license_key = license_key;
		this.dt_activation = dt_activation;
		this.dt_expiry = dt_expiry;
		this.approve_stat = approve_stat;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
	}
	
}
