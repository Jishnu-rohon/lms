package com.rohan.lms.join;

import java.util.List;

import com.rohan.lms.model.AddressType;
import com.rohan.lms.model.ClientNature;
import com.rohan.lms.model.Country;
import com.rohan.lms.model.Gender;
import com.rohan.lms.model.KycType;
import com.rohan.lms.model.ProfessionType;
import com.rohan.lms.model.Religion;

public class MasterData {
	
	private List<AddressType> addressType;
	private List<ClientNature> clientNature;
	private List<Country> country;
	private List<Religion> religion;
	private List<ProfessionType> professionTypes;
	private List<Gender> genders;
	private List<KycType> kycTypes;
	
	public MasterData() {
	}

	public List<AddressType> getAddressType() {
		return addressType;
	}

	public void setAddressType(List<AddressType> addressType) {
		this.addressType = addressType;
	}

	public List<ClientNature> getClientNature() {
		return clientNature;
	}

	public void setClientNature(List<ClientNature> clientNature) {
		this.clientNature = clientNature;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public List<Religion> getReligion() {
		return religion;
	}

	public void setReligion(List<Religion> religion) {
		this.religion = religion;
	}

	public List<ProfessionType> getProfessionTypes() {
		return professionTypes;
	}

	public void setProfessionTypes(List<ProfessionType> professionTypes) {
		this.professionTypes = professionTypes;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public List<KycType> getKycTypes() {
		return kycTypes;
	}

	public void setKycTypes(List<KycType> kycTypes) {
		this.kycTypes = kycTypes;
	}

	@Override
	public String toString() {
		return "MasterData [addressType=" + addressType + ", clientNature=" + clientNature + ", country=" + country
				+ ", religion=" + religion + ", professionTypes=" + professionTypes + ", genders=" + genders
				+ ", kycTypes=" + kycTypes + "]";
	}

	public MasterData(List<AddressType> addressType, List<ClientNature> clientNature, List<Country> country,
			List<Religion> religion, List<ProfessionType> professionTypes, List<Gender> genders,
			List<KycType> kycTypes) {
		super();
		this.addressType = addressType;
		this.clientNature = clientNature;
		this.country = country;
		this.religion = religion;
		this.professionTypes = professionTypes;
		this.genders = genders;
		this.kycTypes = kycTypes;
	}

}
