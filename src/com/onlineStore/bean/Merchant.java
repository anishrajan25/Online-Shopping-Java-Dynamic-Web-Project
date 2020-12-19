package com.onlineStore.bean;

import javax.servlet.http.Part;

public class Merchant extends ParentRecordProfile{
	
	public Merchant(String firstName, String lastName, String email, String password, String address, int status,
			long phoneno, long aadharNumber, Part image) {
		super(firstName, lastName, email, password, address, status, phoneno);
		AadharNumber = aadharNumber;
		this.image = image;
	}

	long AadharNumber;
	Part image;

//		public Admin(String firstName, String lastName, String email, String password, String address, int status,
//				long phoneno) {
//			super(firstName, lastName, email, password, address, status, phoneno);
//			// TODO Auto-generated constructor stub
//			
//		}

		public long getAadharNumber() {
			return AadharNumber;
		}

		public Part getImage() {
			return image;
		}

		public void setAadharNumber(long aadharNumber) {
			AadharNumber = aadharNumber;
		}

		public void setImage(Part image) {
			this.image = image;
		}
}
