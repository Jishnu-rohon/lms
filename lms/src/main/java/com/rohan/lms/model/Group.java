package com.rohan.lms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="m_group")
@JsonIgnoreProperties({"created_date","dt_action","is_deleted"})
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slno;
	private String name;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	
	@OneToMany(mappedBy="grp_slno",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private List<GroupModuleAccess> gma;
	
	public Group() {
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


	public List<GroupModuleAccess> getGma() {
		return gma;
	}


	public void setGma(List<GroupModuleAccess> gma) {
		this.gma = gma;
	}


	@Override
	public String toString() {
		return "Group [slno=" + slno + ", name=" + name + ", created_date=" + created_date + ", dt_action=" + dt_action
				+ ", is_deleted=" + is_deleted + ", gma=" + gma + "]";
	}

	public Group(int slno, String name, Date created_date, Date dt_action, int is_deleted, List<GroupModuleAccess> gma) {
		super();
		this.slno = slno;
		this.name = name;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
		this.gma = gma;
	}
	
}
