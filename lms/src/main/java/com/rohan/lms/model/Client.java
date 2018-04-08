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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	
	@Temporal(TemporalType.DATE)
	private Date dt_register;
	private Integer created_by_user_slno;
	private String saluation;
	private String f_name;
	private String m_name;
	private String l_name;
	private Integer religion_slno;
	
	@ManyToOne(optional=true) // optional true make left outer join and false makes inner join
	@JoinColumn(name="religion_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private Religion religion;
	
	private Integer gender_slno;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="gender_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private Gender gender;
	
	private Date dob;
	
	private Integer client_nature_slno;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="client_nature_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private ClientNature clientNature;
	
	private Integer profession_slno;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="profession_slno",referencedColumnName="slno",insertable=false,updatable=false)
	private ClientProfession profession;
	
	private String email1;
	private String email2;
	private String mobile1;
	private String mobile2;
	
	private String client_desc;
	private String client_restriction;
	private Integer approv_stat;
	
	private Integer company_slno = 0;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_action")
	private Date dt_action;
	
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer is_deleted = 0;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	@JoinColumn(name="clientSlno")
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	@JoinColumn(name="clientSlno")
	//@OneToMany(mappedBy="client",cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	private List<Kyc> kycs;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	@JoinColumn(name="clientProfessionSlno")
	private ClientProfession clientProfessions;
	
	public Client() {

	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Date getDt_register() {
		return dt_register;
	}

	public void setDt_register(Date dt_register) {
		this.dt_register = dt_register;
	}

	public Integer getCreated_by_user_slno() {
		return created_by_user_slno;
	}

	public void setCreated_by_user_slno(Integer created_by_user_slno) {
		this.created_by_user_slno = created_by_user_slno;
	}

	public String getSaluation() {
		return saluation;
	}

	public void setSaluation(String saluation) {
		this.saluation = saluation;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Integer getReligion_slno() {
		return religion_slno;
	}

	public void setReligion_slno(Integer religion_slno) {
		this.religion_slno = religion_slno;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Integer getGender_slno() {
		return gender_slno;
	}

	public void setGender_slno(Integer gender_slno) {
		this.gender_slno = gender_slno;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getClient_nature_slno() {
		return client_nature_slno;
	}

	public void setClient_nature_slno(Integer client_nature_slno) {
		this.client_nature_slno = client_nature_slno;
	}

	public Integer getProfession_slno() {
		return profession_slno;
	}

	public void setProfession_slno(Integer profession_slno) {
		this.profession_slno = profession_slno;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ClientNature getClientNature() {
		return clientNature;
	}

	public void setClientNature(ClientNature clientNature) {
		this.clientNature = clientNature;
	}

	public ClientProfession getProfession() {
		return profession;
	}

	public void setProfession(ClientProfession profession) {
		this.profession = profession;
	}

	public String getClient_desc() {
		return client_desc;
	}

	public void setClient_desc(String client_desc) {
		this.client_desc = client_desc;
	}

	public String getClient_restriction() {
		return client_restriction;
	}

	public void setClient_restriction(String client_restriction) {
		this.client_restriction = client_restriction;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Kyc> getKycs() {
		return kycs;
	}

	public void setKycs(List<Kyc> kycs) {
		this.kycs = kycs;
	}

	public ClientProfession getClientProfessions() {
		return clientProfessions;
	}

	public void setClientProfessions(ClientProfession clientProfessions) {
		this.clientProfessions = clientProfessions;
	}

	@Override
	public String toString() {
		return "Client [slno=" + slno + ", dt_register=" + dt_register + ", created_by_user_slno="
				+ created_by_user_slno + ", saluation=" + saluation + ", f_name=" + f_name + ", m_name=" + m_name
				+ ", l_name=" + l_name + ", religion_slno=" + religion_slno + ", religion=" + religion
				+ ", gender_slno=" + gender_slno + ", gender=" + gender + ", dob=" + dob + ", client_nature_slno="
				+ client_nature_slno + ", clientNature=" + clientNature + ", profession_slno=" + profession_slno
				+ ", profession=" + profession + ", email1=" + email1 + ", email2=" + email2 + ", mobile1=" + mobile1
				+ ", mobile2=" + mobile2 + ", client_desc=" + client_desc + ", client_restriction=" + client_restriction
				+ ", approv_stat=" + approv_stat + ", company_slno=" + company_slno + ", created_date=" + created_date
				+ ", dt_action=" + dt_action + ", is_deleted=" + is_deleted + ", addresses=" + addresses + ", kycs="
				+ kycs + ", clientProfessions=" + clientProfessions + "]";
	}

	public Client(Integer slno, Date dt_register, Integer created_by_user_slno, String saluation, String f_name,
			String m_name, String l_name, Integer religion_slno, Religion religion, Integer gender_slno, Gender gender,
			Date dob, Integer client_nature_slno, ClientNature clientNature, Integer profession_slno,
			ClientProfession profession, String email1, String email2, String mobile1, String mobile2,
			String client_desc, String client_restriction, Integer approv_stat, Integer company_slno, Date created_date,
			Date dt_action, Integer is_deleted, List<Address> addresses, List<Kyc> kycs,
			ClientProfession clientProfessions) {
		super();
		this.slno = slno;
		this.dt_register = dt_register;
		this.created_by_user_slno = created_by_user_slno;
		this.saluation = saluation;
		this.f_name = f_name;
		this.m_name = m_name;
		this.l_name = l_name;
		this.religion_slno = religion_slno;
		this.religion = religion;
		this.gender_slno = gender_slno;
		this.gender = gender;
		this.dob = dob;
		this.client_nature_slno = client_nature_slno;
		this.clientNature = clientNature;
		this.profession_slno = profession_slno;
		this.profession = profession;
		this.email1 = email1;
		this.email2 = email2;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.client_desc = client_desc;
		this.client_restriction = client_restriction;
		this.approv_stat = approv_stat;
		this.company_slno = company_slno;
		this.created_date = created_date;
		this.dt_action = dt_action;
		this.is_deleted = is_deleted;
		this.addresses = addresses;
		this.kycs = kycs;
		this.clientProfessions = clientProfessions;
	}

}
