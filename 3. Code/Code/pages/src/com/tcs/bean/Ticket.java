package com.tcs.bean;

public class Ticket {
	int ticket_ID;
	double price;
	int customer_ID;
	int show_ID;
	int seat_No;
	
	public int getTicket_ID() {
		return ticket_ID;
	}
	public void setTicket_ID(int ticket_ID) {
		this.ticket_ID = ticket_ID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public int getShow_ID() {
		return show_ID;
	}
	public void setShow_ID(int show_ID) {
		this.show_ID = show_ID;
	}
	public int getSeat_No() {
		return seat_No;
	}
	public void setSeat_No(int seat_No) {
		this.seat_No = seat_No;
	}

}
