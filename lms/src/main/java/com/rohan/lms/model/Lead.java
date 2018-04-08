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
@Table(name="tbl_lead")
public class Lead {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
//	private Date dt_lead_create;
	private Integer created_by_user_slno;
	private Integer client_slno;
	private Integer lead_source_slno;
	private String mode_of_contact;
	
	private Integer p_service_slno;
	
	private Integer s_service_slno;
	
	private Integer othr_service_slno;
	
	private Integer lead_rating_slno;
	private Integer lead_stat_slno;
	private String comnt;
	private Integer approv_stat;
	
	private Integer company_slno;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private Integer is_deleted;

	Lead(){ }
	
	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getCreated_by_user_slno() {
		return created_by_user_slno;
	}

	public void setCreated_by_user_slno(Integer created_by_user_slno) {
		this.created_by_user_slno = created_by_user_slno;
	}

	public Integer getClient_slno() {
		return client_slno;
	}

	public void setClient_slno(Integer client_slno) {
		this.client_slno = client_slno;
	}

	public Integer getLead_source_slno() {
		return lead_source_slno;
	}

	public void setLead_source_slno(Integer lead_source_slno) {
		this.lead_source_slno = lead_source_slno;
	}

	public String getMode_of_contact() {
		return mode_of_contact;
	}

	public void setMode_of_contact(String mode_of_contact) {
		this.mode_of_contact = mode_of_contact;
	}

	public Integer getP_service_slno() {
		return p_service_slno;
	}

	public void setP_service_slno(Integer p_service_slno) {
		this.p_service_slno = p_service_slno;
	}

	public Integer getS_service_slno() {
		return s_service_slno;
	}

	public void setS_service_slno(Integer s_service_slno) {
		this.s_service_slno = s_service_slno;
	}

	public Integer getOthr_service_slno() {
		return othr_service_slno;
	}

	public void setOthr_service_slno(Integer othr_service_slno) {
		this.othr_service_slno = othr_service_slno;
	}

	public Integer getLead_rating_slno() {
		return lead_rating_slno;
	}

	public void setLead_rating_slno(Integer lead_rating_slno) {
		this.lead_rating_slno = lead_rating_slno;
	}

	public Integer getLead_stat_slno() {
		return lead_stat_slno;
	}

	public void setLead_stat_slno(Integer lead_stat_slno) {
		this.lead_stat_slno = lead_stat_slno;
	}

	public String getComnt() {
		return comnt;
	}

	public void setComnt(String comnt) {
		this.comnt = comnt;
	}

	public Integer getApprov_stat() {
		return approv_stat;
	}

	public void setApprov_stat(Integer approv_stat) {
		this.approv_stat = approv_stat;
	}

	public Integer getCompany_slno() {
		return company_slno;
	}

	public void setCompany_slno(Integer company_slno) {
		this.company_slno = company_slno;
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

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Lead [slno=" + slno + ", created_by_user_slno=" + created_by_user_slno + ", client_slno=" + client_slno
				+ ", lead_source_slno=" + lead_source_slno + ", mode_of_contact=" + mode_of_contact
				+ ", p_service_slno=" + p_service_slno + ", s_service_slno=" + s_service_slno + ", othr_service_slno="
				+ othr_service_slno + ", lead_rating_slno=" + lead_rating_slno + ", lead_stat_slno=" + lead_stat_slno
				+ ", comnt=" + comnt + ", approv_stat=" + approv_stat + ", company_slno=" + company_slno
				+ ", created_date=" + created_date + ", dt_action=" + dt_action + ", is_deleted=" + is_deleted + "]";
	}

	public Lead(Integer slno, Integer created_by_user_slno, Integer client_slno, Integer lead_source_slno,
			String mode_of_contact, Integer p_service_slno, Integer s_service_slno, Integer othr_service_slno,
			Integer lead_rating_slno, Integer lead_stat_slno, String comnt, Integer approv_stat, Integer company_slno,
			Date created_date, Date dt_action, Integer is_deleted) {
		super();
		this.slno = slno;
		this.created_by_user_slno = created_by_user_slno;
		this.client_slno = client_slno;
		this.lead_source_slno = lead_source_slno;
		this.mode_of_contact = mode_of_contact;
		this.p_service_slno = p_service_slno;
		this.s_service_slno = s_service_slno;
		this.othr_service_slno = othr_service_slno;
		this.lead_rating_slno = lead_rating_slno;
		this.lead_stat_slno = lead_stat_slno;
		this.comnt = comnt;
		this.approv_stat = approv_stat;
		this.company_slno = company_slno;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
	}

}
