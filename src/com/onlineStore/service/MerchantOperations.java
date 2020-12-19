package com.onlineStore.service;

import com.onlineStore.bean.Merchant;
import com.onlineStore.dao.DataBaseAdd;

public class MerchantOperations {
	public boolean addMerchant(Merchant merchant)
	{
		//System.out.println("Merchant operations class Entered");
		DataBaseAdd db=new DataBaseAdd();
		return db.addMerchant(merchant);
	}
}
