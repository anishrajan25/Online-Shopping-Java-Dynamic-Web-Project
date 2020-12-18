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
protected void setFirstName(String firstName) {
	FirstName = firstName;
}
protected String getFirstName() {
	return FirstName;
}
protected void setLastName(String lastName) {
	LastName = lastName;
}
protected String getLastName() {
	return LastName;
}
protected void setEmail(String email) {
	Email = email;
}
protected String getEmail() {
	return Email;
}
protected void setPassword(String password) {
	Password = password;
}
protected String getPassword() {
	return Password;
}
protected void setAddress(String address) {
	Address = address;
}
protected String getAddress() {
	return Address;
}
protected void setStatus(int status) {
	Status = status;
}
protected int getStatus() {
	return Status;
}
protected void setPhoneno(long phoneno) {
	Phoneno = phoneno;
}
protected long getPhoneno() {
	return Phoneno;
}

protected String GeneratePassword()
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
