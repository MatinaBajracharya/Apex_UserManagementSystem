package com.usermgmt.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegistrationForm {

	@NotEmpty(message = "firstname should not be empty")
	private String fname;
	
	private String mname;
	
	@NotEmpty(message = "lastname should not be empty")
	private String lname;
	
	@NotEmpty(message = "Email should not be empty")
	private String email;
	
	@NotEmpty(message = "Password should not be empty")
	private String pass1;
	
	@NotEmpty(message = "Confirm Password should not be empty")
	private String pass2;
	
	@NotEmpty(message = "Answer should not be empty")
	private String ans1;
	
	@NotEmpty(message = "Answer should not be empty")
	private String ans2;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

}
