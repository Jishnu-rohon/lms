package com.rohan.lms.utility;

public class JWTHeader {
	private String login_id;
	private int user_slno;
	private int company_slno;
	
	public JWTHeader() {
		// TODO Auto-generated constructor stub
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public int getUser_slno() {
		return user_slno;
	}

	public void setUser_slno(int user_slno) {
		this.user_slno = user_slno;
	}

	public int getCompany_slno() {
		return company_slno;
	}

	public void setCompany_slno(int company_slno) {
		this.company_slno = company_slno;
	}

	@Override
	public String toString() {
		return "JWTHeader [login_id=" + login_id + ", user_slno=" + user_slno + ", company_slno=" + company_slno + "]";
	}

	public JWTHeader(String login_id, int user_slno, int company_slno) {
		super();
		this.login_id = login_id;
		this.user_slno = user_slno;
		this.company_slno = company_slno;
	}
	
}
