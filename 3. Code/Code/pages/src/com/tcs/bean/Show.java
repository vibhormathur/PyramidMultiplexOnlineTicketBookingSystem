package com.tcs.bean;

public class Show {
	
	int show_ID;
	String show_Date;
	String slot;
	int seat_Capacity;
	int seat_Occupancy;
	int movie_ID;
	
	
	public String getShow_Date() {
		return show_Date;
	}
	public void setShow_Date(String show_Date) {
		this.show_Date = show_Date;
	}
	public int getShow_ID() {
		return show_ID;
	}
	public void setShow_ID(int show_ID) {
		this.show_ID = show_ID;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public int getSeat_Capacity() {
		return seat_Capacity;
	}
	public void setSeat_Capacity(int seat_Capacity) {
		this.seat_Capacity = seat_Capacity;
	}
	public int getSeat_Occupancy() {
		return seat_Occupancy;
	}
	public void setSeat_Occupancy(int seat_Occupancy) {
		this.seat_Occupancy = seat_Occupancy;
	}
	public int getMovie_ID() {
		return movie_ID;
	}
	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}
	
}
