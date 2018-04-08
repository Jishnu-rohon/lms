package com.rohan.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="m_module")
@JsonIgnoreProperties({"created_date","dt_action","is_deleted"})
public class Module {
	@Id
	@GeneratedValue
	private int slno;
	private String name;
	private String url;
	
	private int parent_slno;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	public Module() {
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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

	public int getParent_slno() {
		return parent_slno;
	}

	public void setParent_slno(int parent_slno) {
		this.parent_slno = parent_slno;
	}

	@Override
	public String toString() {
		return "Module [slno=" + slno + ", name=" + name + ", url=" + url + ", parent_slno=" + parent_slno
				+ ", created_date=" + created_date + ", dt_action=" + dt_action + ", is_deleted=" + is_deleted + "]";
	}

	public Module(int slno, String name, String url, int parent_slno, Date created_date, Date dt_action,
			int is_deleted) {
		super();
		this.slno = slno;
		this.name = name;
		this.url = url;
		this.parent_slno = parent_slno;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
	}
	
}
