package com.tcs.utility;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tcs.bean.*;

public class InsertMovieTable 
{
public void insertMovie(Movie mov) 
{
	Date newclosingdate=null;
	Date newopeningdate=null;
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		int maxMovieId=0;
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			ResultSet rs =(ResultSet) stmt.executeQuery("SELECT MAX(Movie_Id) FROM G4_movie");
			
			while (rs.next()) {
				maxMovieId=rs.getInt(1);
			}
			maxMovieId+=1;
			mov.setMovie_ID(maxMovieId);
		}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		}
		System.out.println(maxMovieId);
		Date maxdate=null;
		int theater_id = mov.getTheater_ID();
		try
		{
			
			
			System.out.println("check1");
			ResultSet rs =(ResultSet) stmt.executeQuery("SELECT MAX(Closing_date) FROM G4_movie where theatre_id="+theater_id+"");
			System.out.println(theater_id);
			if(rs.next())
			{
			maxdate = (Date)rs.getDate(1);
			}
			System.out.println(maxdate);
		}catch(SQLException sqex){
			System.out.println(sqex);
		}
		try
		{
			ResultSet rs =(ResultSet) stmt.executeQuery("SELECT to_date('"+maxdate+"','yyyy-mm-dd')+1 from dual");
		
		
		if(rs.next())
		{
		newopeningdate = (Date)rs.getDate(1);
		}
		System.out.println(newopeningdate);
		}catch(SQLException sqex){
			System.out.println(sqex);
		}
		
		try
		{
			ResultSet rs =(ResultSet) stmt.executeQuery("SELECT to_date('"+maxdate+"','yyyy-mm-dd')+7 from dual");
		
		
		if(rs.next())
		{
		newclosingdate = (Date)rs.getDate(1);
		}
		System.out.println(newclosingdate);
		}catch(SQLException sqex){
			System.out.println(sqex);
		}
		DateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy");
	    
		String dateString= dateFormat.format(newopeningdate);
		String dateString1= dateFormat.format(newclosingdate);
		System.out.println(dateString);
		try{
			
			
			stmt.executeQuery("INSERT INTO G4_Movie VALUES("+mov.getMovie_ID()+",'"+mov.getMovie_Name()+"','"+mov.getDirector()+"','"+mov.getLanguage()+"','"+dateString+"','"+dateString1+"',"+mov.getResponse()+","+mov.getTheater_ID()+")");
			System.out.println("one row inserted ");
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
		
		int maxshowId=0 , seat_capacity=0,i=0;
		
		try
		{
            ResultSet rs =(ResultSet) stmt.executeQuery("SELECT MAX(Show_Id) FROM G4_show");
			
			while (rs.next()) {
				maxshowId=rs.getInt(1);
			}
			System.out.println(maxshowId);
			
			ResultSet rs1 =(ResultSet) stmt.executeQuery("SELECT seat_capacity FROM G4_theater where theater_id="+mov.getTheater_ID()+"");
			while(rs1.next())
			{
				seat_capacity=rs1.getInt(1);
			}
			System.out.println(seat_capacity);
			Date nxtdate=null;
			for(i=1;i<=7;i++)
			{
				System.out.println("check 1");
				maxshowId+=1;
				stmt.executeQuery("insert into g4_show values("+maxshowId+",'"+dateString+"','A',0,"+mov.getMovie_ID()+","+seat_capacity+")");
				
				maxshowId+=1;
				stmt.executeQuery("insert into g4_show values("+maxshowId+",'"+dateString+"','B',0,"+mov.getMovie_ID()+","+seat_capacity+")");
				
				maxshowId+=1;
				stmt.executeQuery("insert into g4_show values("+maxshowId+",'"+dateString+"','C',0,"+mov.getMovie_ID()+","+seat_capacity+")");
				System.out.println("check 2");
				rs = stmt.executeQuery("SELECT to_date('"+maxdate+"','yyyy-mm-dd')+"+i+" from dual");
				if(rs.next())
				{
					 nxtdate = (Date)rs.getDate(1);
				}
				System.out.println("check 3");
			    
			    dateString= dateFormat.format(nxtdate);
			    System.out.println("check 4");
			}
			System.out.println("Show Inserted");
			
		}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
	}
public void createMovie(Movie mov) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeQuery("Create TABLE G4_Movie (Movie_Name varchar2(50),Movie_ID number(5),Director varchar2(50),Language varchar2(25),Opening_Date date,Closing_Date date,Response number(1),Theater_ID number(2))");
			System.out.println("Table Created ");
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
      
		
		
	

	}
public boolean checkMovie(String movie) 
{
		boolean status=false;
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from G4_Movie where movie_name = '"+movie+"'");
			if(rs.next())
			{
				status=true;
			}
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
		/*finally{
			stmt.close();
			con.close();
			System.out.println("Connection closed successfully");
		}*/
        
		return status;
	}
}
