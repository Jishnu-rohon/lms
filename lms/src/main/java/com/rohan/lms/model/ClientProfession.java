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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="op_client_profession")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientProfession {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	private Integer professionTypeSlno;
	private String designation;
	private String companyName;
	private String companyAddress;
	private Integer citySlno;
	private Integer stateSlno;
	private Integer countrySlno;
	private String pin;
	private String officePhone;
	private String officeEmail;
	private String businessCard;
	private Integer approveStat;
	
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer companySlno=0;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_action")
	private Date dtAction;
	
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer isDeleted=0;
	
	public ClientProfession() { }

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getProfessionTypeSlno() {
		return professionTypeSlno;
	}

	public void setProfessionTypeSlno(Integer professionTypeSlno) {
		this.professionTypeSlno = professionTypeSlno;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Integer getCitySlno() {
		return citySlno;
	}

	public void setCitySlno(Integer citySlno) {
		this.citySlno = citySlno;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getBusinessCard() {
		return businessCard;
	}

	public void setBusinessCard(String businessCard) {
		this.businessCard = businessCard;
	}

	public Integer getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(Integer approveStat) {
		this.approveStat = approveStat;
	}

	public Integer getCompanySlno() {
		return companySlno;
	}

	public void setCompanySlno(Integer companySlno) {
		this.companySlno = companySlno;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

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

	@Override
	public String toString() {
		return "ClientProfession [slno=" + slno + ", professionTypeSlno=" + professionTypeSlno + ", designation="
				+ designation + ", companyName=" + companyName + ", companyAddress=" + companyAddress + ", citySlno="
				+ citySlno + ", stateSlno=" + stateSlno + ", countrySlno=" + countrySlno + ", pin=" + pin
				+ ", officePhone=" + officePhone + ", officeEmail=" + officeEmail + ", businessCard=" + businessCard
				+ ", approveStat=" + approveStat + ", companySlno=" + companySlno + ", createdDate=" + createdDate
				+ ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}

	public ClientProfession(Integer slno, Integer professionTypeSlno, String designation, String companyName,
			String companyAddress, Integer citySlno, Integer stateSlno, Integer countrySlno, String pin,
			String officePhone, String officeEmail, String businessCard, Integer approveStat, Integer companySlno,
			Date createdDate, Date dtAction, Integer isDeleted) {
		super();
		this.slno = slno;
		this.professionTypeSlno = professionTypeSlno;
		this.designation = designation;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.citySlno = citySlno;
		this.stateSlno = stateSlno;
		this.countrySlno = countrySlno;
		this.pin = pin;
		this.officePhone = officePhone;
		this.officeEmail = officeEmail;
		this.businessCard = businessCard;
		this.approveStat = approveStat;
		this.companySlno = companySlno;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
