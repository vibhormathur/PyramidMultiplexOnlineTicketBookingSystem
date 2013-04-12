package com.tcs.bean;

public class Movie {

	int movie_ID;
	String movie_Name;
	String director;
	String language;
	String opening_Date;
	String closing_Date;
	double response;
	int theater_ID;
	
	public int getMovie_ID() {
		return movie_ID;
	}
	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}
	public String getMovie_Name() {
		return movie_Name;
	}
	public void setMovie_Name(String movie_Name) {
		this.movie_Name = movie_Name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getClosing_Date() {
		return closing_Date;
	}
	public void setClosing_Date(String closing_Date) {
		this.closing_Date = closing_Date;
	}
	public double getResponse() {
		return response;
	}
	public void setResponse(double response) {
		this.response = response;
	}
	public int getTheater_ID() {
		return theater_ID;
	}
	public void setTheater_ID(int theater_ID) {
		this.theater_ID = theater_ID;
	}
	
	
}
