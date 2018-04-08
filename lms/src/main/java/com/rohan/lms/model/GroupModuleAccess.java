package com.rohan.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"created_date","dt_action","is_deleted"})
@Entity
@Table(name="m_group_module_access")

public class GroupModuleAccess {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private int grp_slno;
	private int mod_slno;
	private int is_all;
	private int is_view;
	private int is_add;
	private int is_edit;
	private int is_delete;
	private int is_none;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="mod_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private Module module;

	public GroupModuleAccess() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public int getGrp_slno() {
		return grp_slno;
	}

	public void setGrp_slno(int grp_slno) {
		this.grp_slno = grp_slno;
	}

	public int getMod_slno() {
		return mod_slno;
	}

	public void setMod_slno(int mod_slno) {
		this.mod_slno = mod_slno;
	}

	public int getIs_all() {
		return is_all;
	}

	public void setIs_all(int is_all) {
		this.is_all = is_all;
	}

	public int getIs_view() {
		return is_view;
	}

	public void setIs_view(int is_view) {
		this.is_view = is_view;
	}

	public int getIs_add() {
		return is_add;
	}

	public void setIs_add(int is_add) {
		this.is_add = is_add;
	}

	public int getIs_edit() {
		return is_edit;
	}

	public void setIs_edit(int is_edit) {
		this.is_edit = is_edit;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public int getIs_none() {
		return is_none;
	}

	public void setIs_none(int is_none) {
		this.is_none = is_none;
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "GroupModuleAccess [slno=" + slno + ", grp_slno=" + grp_slno + ", mod_slno=" + mod_slno + ", is_all="
				+ is_all + ", is_view=" + is_view + ", is_add=" + is_add + ", is_edit=" + is_edit + ", is_delete="
				+ is_delete + ", is_none=" + is_none + ", created_date=" + created_date + ", dt_action=" + dt_action
				+ ", is_deleted=" + is_deleted + ", module=" + module + "]";
	}

	public GroupModuleAccess(int slno, int grp_slno, int mod_slno, int is_all, int is_view, int is_add, int is_edit,
			int is_delete, int is_none, Date created_date, Date dt_action, int is_deleted, Module module) {
		super();
		this.slno = slno;
		this.grp_slno = grp_slno;
		this.mod_slno = mod_slno;
		this.is_all = is_all;
		this.is_view = is_view;
		this.is_add = is_add;
		this.is_edit = is_edit;
		this.is_delete = is_delete;
		this.is_none = is_none;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
		this.module = module;
	}

}
