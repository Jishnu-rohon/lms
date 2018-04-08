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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="m_address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	
	private Integer clientSlno;
	
	@Column(name="address_type_slno")
	private Integer addressTypeSlno=0;
	private String street;
	private Integer citySlno;
	
	@Transient
	private String cityName;
	
	private Integer stateSlno;
	
	@Transient
	private String stateName;
	
	private Integer countrySlno;
	
	@Transient
	private String countryName;
	
	private Integer pinSlno;
	private Integer approveStat;
	
	@Column(nullable=true)
	private Integer companySlno=0;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Type(type="date")
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	
	private Integer isDeleted=0;
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clientSlno",insertable=false,updatable=false)
	private Client client;*/
	
	public Address() {
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getClientSlno() {
		return clientSlno;
	}

	public void setClientSlno(Integer clientSlno) {
		this.clientSlno = clientSlno;
	}

	public Integer getAddressTypeSlno() {
		return addressTypeSlno;
	}

	public void setAddressTypeSlno(Integer addressTypeSlno) {
		this.addressTypeSlno = addressTypeSlno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getCitySlno() {
		return citySlno;
	}

	public void setCitySlno(Integer citySlno) {
		this.citySlno = citySlno;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getStateSlno() {
		return stateSlno;
	}

	public void setStateSlno(Integer stateSlno) {
		this.stateSlno = stateSlno;
	}

	public Integer getCountrySlno() {
		return countrySlno;
	}

	public void setCountrySlno(Integer countrySlno) {
		this.countrySlno = countrySlno;
	}

	public Integer getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(Integer approveStat) {
		this.approveStat = approveStat;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.000 ", timezone="UTC")
	public Date getDtAction() {
		return dtAction;
	}

	public void setDtAction(Date dtAction) {
		this.dtAction = dtAction;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getPinSlno() {
		return pinSlno;
	}

	public void setPinSlno(Integer pinSlno) {
		this.pinSlno = pinSlno;
	}

	public Integer getCompanySlno() {
		return companySlno;
	}

	public void setCompanySlno(Integer companySlno) {
		this.companySlno = companySlno;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Address [slno=" + slno + ", clientSlno=" + clientSlno + ", addressTypeSlno=" + addressTypeSlno
				+ ", street=" + street + ", citySlno=" + citySlno + ", cityName=" + cityName + ", stateSlno="
				+ stateSlno + ", stateName=" + stateName + ", countrySlno=" + countrySlno + ", countryName="
				+ countryName + ", pinSlno=" + pinSlno + ", approveStat=" + approveStat + ", companySlno=" + companySlno
				+ ", createdDate=" + createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}

	public Address(Integer slno, Integer clientSlno, Integer addressTypeSlno, String street, Integer citySlno,
			String cityName, Integer stateSlno, String stateName, Integer countrySlno, String countryName,
			Integer pinSlno, Integer approveStat, Integer companySlno, Date createdDate, Date dtAction,
			Integer isDeleted) {
		super();
		this.slno = slno;
		this.clientSlno = clientSlno;
		this.addressTypeSlno = addressTypeSlno;
		this.street = street;
		this.citySlno = citySlno;
		this.cityName = cityName;
		this.stateSlno = stateSlno;
		this.stateName = stateName;
		this.countrySlno = countrySlno;
		this.countryName = countryName;
		this.pinSlno = pinSlno;
		this.approveStat = approveStat;
		this.companySlno = companySlno;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
