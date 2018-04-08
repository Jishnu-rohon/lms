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

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="m_product_service")
public class ProductService {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer slno;
	private Integer productSlno;
	private String serviceName;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_action")
	private Date dtAction;
	private Integer approv_stat;
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer isDeleted = 0;
	
	public ProductService() { }

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getProductSlno() {
		return productSlno;
	}

	public void setProductSlno(Integer productSlno) {
		this.productSlno = productSlno;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getDtAction() {
		return dtAction;
	}

	public void setDtAction(Date dtAction) {
		this.dtAction = dtAction;
	}

	public Integer getApprov_stat() {
		return approv_stat;
	}

	public void setApprov_stat(Integer approv_stat) {
		this.approv_stat = approv_stat;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "ProductService [slno=" + slno + ", productSlno=" + productSlno + ", serviceName=" + serviceName
				+ ", dtAction=" + dtAction + ", approv_stat=" + approv_stat + ", isDeleted=" + isDeleted + "]";
	}

	public ProductService(Integer slno, Integer productSlno, String serviceName, Date dtAction, Integer approv_stat,
			Integer isDeleted) {
		super();
		this.slno = slno;
		this.productSlno = productSlno;
		this.serviceName = serviceName;
		this.dtAction = dtAction;
		this.approv_stat = approv_stat;
		this.isDeleted = isDeleted;
	}

}
