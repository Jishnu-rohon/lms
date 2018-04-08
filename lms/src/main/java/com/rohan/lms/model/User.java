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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="tbl_user")
@JsonIgnoreProperties({"created_date","dt_action","is_deleted"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long slno;
	private int license_slno;
	private String loginId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String loginPass;
	private String comnt;
	private String approv_stat;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dt_action;
	
	private int is_deleted;
	
	private int grpSlno;
	
	@Transient
	private String token;
	
	private int company_slno;
	
	/*@OneToOne
	@JoinColumn(name="company_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private Company company;
	
	@OneToOne
	@JoinColumn(name="grpSlno",referencedColumnName="slno",insertable=false,updatable=false)
	private Group group;
	
	@OneToMany(mappedBy="usr_slno",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private List<UserModuleAccess> uma;*/
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public int getLicense_slno() {
		return license_slno;
	}

	public void setLicense_slno(Integer license_slno) {
		if(license_slno==null)
			this.license_slno = 0;
		else
			this.license_slno = license_slno;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getComnt() {
		return comnt;
	}

	public void setComnt(String comnt) {
		this.comnt = comnt;
	}

	public String getApprov_stat() {
		return approv_stat;
	}

	public void setApprov_stat(String approv_stat) {
		this.approv_stat = approv_stat;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getGrpSlno() {
		return grpSlno;
	}

	public void setGrpSlno(int grpSlno) {
		this.grpSlno = grpSlno;
	}

	public void setLicense_slno(int license_slno) {
		this.license_slno = license_slno;
	}

	public int getCompany_slno() {
		return company_slno;
	}

	public void setCompany_slno(int company_slno) {
		this.company_slno = company_slno;
	}

	@Override
	public String toString() {
		return "User [slno=" + slno + ", license_slno=" + license_slno + ", loginId=" + loginId + ", loginPass="
				+ loginPass + ", comnt=" + comnt + ", approv_stat=" + approv_stat + ", created_date=" + created_date
				+ ", dt_action=" + dt_action + ", is_deleted=" + is_deleted + ", grpSlno=" + grpSlno + ", token="
				+ token + ", company_slno=" + company_slno + "]";
	}

	public User(Long slno, int license_slno, String loginId, String loginPass, String comnt, String approv_stat,
			Date created_date, Date dt_action, int is_deleted, int grpSlno, String token, int company_slno) {
		super();
		this.slno = slno;
		this.license_slno = license_slno;
		this.loginId = loginId;
		this.loginPass = loginPass;
		this.comnt = comnt;
		this.approv_stat = approv_stat;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
		this.grpSlno = grpSlno;
		this.token = token;
		this.company_slno = company_slno;
	}

}
