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
@Table(name="m_kyc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kyc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	
	private Integer clientSlno;
	
	private Integer kycTypeSlno;
	private String identificationNumber;
	private String imageName;
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
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clientSlno")
	private Client client;*/
	
	public Kyc() { }
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public Integer getKycTypeSlno() {
		return kycTypeSlno;
	}
	public void setKycTypeSlno(Integer kycTypeSlno) {
		this.kycTypeSlno = kycTypeSlno;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public Integer getClientSlno() {
		return clientSlno;
	}
	public void setClientSlno(Integer clientSlno) {
		this.clientSlno = clientSlno;
	}
	@Override
	public String toString() {
		return "Kyc [slno=" + slno + ", clientSlno=" + clientSlno + ", kycTypeSlno=" + kycTypeSlno
				+ ", identificationNumber=" + identificationNumber + ", imageName=" + imageName + ", createdDate="
				+ createdDate + ", dtAction=" + dtAction + ", isDeleted=" + isDeleted + "]";
	}
	public Kyc(Integer slno, Integer clientSlno, Integer kycTypeSlno, String identificationNumber, String imageName,
			Date createdDate, Date dtAction, Integer isDeleted) {
		super();
		this.slno = slno;
		this.clientSlno = clientSlno;
		this.kycTypeSlno = kycTypeSlno;
		this.identificationNumber = identificationNumber;
		this.imageName = imageName;
		this.createdDate = createdDate;
		this.dtAction = dtAction;
		this.isDeleted = isDeleted;
	}

}
