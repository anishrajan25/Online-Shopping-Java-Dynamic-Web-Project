package com.onlineStore.service;

import com.onlineStore.bean.Merchant;
import com.onlineStore.dao.DataBaseAdd;
import com.onlineStore.dao.DataBaseDelete;
import com.onlineStore.dao.DataBaseVerify;

public class MerchantOperations {
	public boolean addMerchant(Merchant merchant)
	{
		//System.out.println("Merchant operations class Entered");
		DataBaseAdd db=new DataBaseAdd();
		return db.addMerchant(merchant);
	}
	public boolean verifyMerchant(String email,String Password)
	{
		DataBaseVerify db=new DataBaseVerify();
		return db.verifyMerchant(email, Password);
	}
	public boolean deleteMerchant(String id)
	{
		DataBaseDelete db=new DataBaseDelete();
		db.deleteMerchant(id);
		return true;
	}
}
