package com.onlineStore.bean;

public class ParentRecordProfile {
	public ParentRecordProfile(String firstName, String lastName, String email, String password, String address, int status,
			long phoneno) {
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		Address = address;
		Status = status;
		Phoneno = phoneno;
	}
	public ParentRecordProfile()
	{
		
	}
String FirstName,LastName,Email,Password,Address;
int Status;
long Phoneno;
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getFirstName() {
	return FirstName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getLastName() {
	return LastName;
}
public void setEmail(String email) {
	Email = email;
}
public String getEmail() {
	return Email;
}
public void setPassword(String password) {
	Password = password;
}
public String getPassword() {
	return Password;
}
public void setAddress(String address) {
	Address = address;
}
public String getAddress() {
	return Address;
}
public void setStatus(int status) {
	Status = status;
}
public int getStatus() {
	return Status;
}
public void setPhoneno(long phoneno) {
	Phoneno = phoneno;
}
public long getPhoneno() {
	return Phoneno;
}

public String GeneratePassword()
{
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<13;i++)
	{
		sb.append((char)(Math.random()*93+33));
	}
	//System.out.println(sb.toString());
	return sb.toString();
}
//public static void main(String[] args)
//{
//	ParentRecordProfile pf=new ParentRecordProfile();
//	pf.GeneratePassword();
//}
}
