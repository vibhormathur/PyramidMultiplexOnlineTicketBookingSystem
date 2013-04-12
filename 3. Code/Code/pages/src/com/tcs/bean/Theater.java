package com.tcs.bean;

public class Theater {
	String theater_Name;
	int theater_ID;
	int seat_Capacity;
	double price;
	int rating;

	
	public String getTheater_Name()
	{
		return this.theater_Name;
	}
	public void setTheater_Name(String name)
	{
		this.theater_Name=name;
	}
	
	public void setTheater_ID(int theater_ID)
	{
		this.theater_ID=theater_ID;
	}
	public int getTheater_ID()
	{
		return this.theater_ID;
	}
	
	public int getSeat_Capacity()
	{
		return this.seat_Capacity;
	}
	public void setSeat_Capacity(int seat_Capacity)
	{
		this.seat_Capacity=seat_Capacity;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	public int getRating()
	{
		return this.rating;
	}
	public void setRating(int rating)
	{
		this.rating=rating;
	}
	
}
