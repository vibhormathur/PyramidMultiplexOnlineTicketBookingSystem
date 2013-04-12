package com.tcs.bean;

public class Customer 
{
	String name;
	String username;
	String password;
	int age;
	String gender;
	String address;
	String phoneno;
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getGender()
	{
		return this.gender;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getPhoneNo()
	{
		return this.phoneno;
	}
	public void setPhoneNo(String phoneno)
	{
		this.phoneno=phoneno;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
}
