package com.onlineStore.bean;

import javax.servlet.http.Part;

public class Admin extends ParentRecordProfile {


public Admin(String firstName, String lastName, String email, String password, String address, int status,
			long phoneno, long aadharNumber, Part image) {
		super(firstName, lastName, email, password, address, status, phoneno);
		AadharNumber = aadharNumber;
		this.image = image;
	}

long AadharNumber;
Part image;

//	public Admin(String firstName, String lastName, String email, String password, String address, int status,
//			long phoneno) {
//		super(firstName, lastName, email, password, address, status, phoneno);
//		// TODO Auto-generated constructor stub
//		
//	}

	private long getAadharNumber() {
		return AadharNumber;
	}

	private Part getImage() {
		return image;
	}

	private void setAadharNumber(long aadharNumber) {
		AadharNumber = aadharNumber;
	}

	private void setImage(Part image) {
		this.image = image;
	}

}
