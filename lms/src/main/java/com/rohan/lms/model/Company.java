package com.rohan.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="m_company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String name;
	private String address;
	private String business;
	private int license_slno;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	
	@OneToOne
	@JoinColumn(name="license_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private License license;
	
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
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
	public int getLicense_slno() {
		return license_slno;
	}
	public void setLicense_slno(int license_slno) {
		this.license_slno = license_slno;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	@Override
	public String toString() {
		return "Company [slno=" + slno + ", name=" + name + ", address=" + address + ", business=" + business
				+ ", license_slno=" + license_slno + ", created_date=" + created_date + ", dt_action=" + dt_action
				+ ", is_deleted=" + is_deleted + ", license=" + license + "]";
	}
	public Company(int slno, String name, String address, String business, int license_slno, Date created_date,
			Date dt_action, int is_deleted, License license) {
		super();
		this.slno = slno;
		this.name = name;
		this.address = address;
		this.business = business;
		this.license_slno = license_slno;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
		this.license = license;
	}

}
