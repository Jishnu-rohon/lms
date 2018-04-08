package com.rohan.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_country")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slno;
	private String countryCode;
	private String countryName;
	private int approvStat;
	private String phonecode;
	
	public Country() {
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getApprovStat() {
		return approvStat;
	}

	public void setApprovStat(int approvStat) {
		this.approvStat = approvStat;
	}

	public String getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}

	@Override
	public String toString() {
		return "Country [slno=" + slno + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", approvStat=" + approvStat + ", phonecode=" + phonecode + "]";
	}

	public Country(int slno, String countryCode, String countryName, int approvStat, String phonecode) {
		super();
		this.slno = slno;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.approvStat = approvStat;
		this.phonecode = phonecode;
	}
	
}
