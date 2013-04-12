package com.tcs.utility;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;


import com.tcs.bean.Select_movie_bean;
public class Select_Movie_action {

	ArrayList abcd = new ArrayList();
	
	public ArrayList check(Select_movie_bean smb)
	{
	
		//Date date = smb.getDate();
	DbConnection dbconObj=new DbConnection();
	Connection con = null;
	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	System.out.println(smb.getDate());
	System.out.println("***************************");
	String querystring="SELECT * FROM G4_MOVIE WHERE CLOSING_DATE > ? ";
	System.out.println("+++++++++++++++++++++++++++++++");
	//System.out.println(date);
	//System.out.println(Date.valueOf(ab));
	String ab=smb.getDate();
	String ne = ab.substring(6,10) + "-" + ab.substring(0,2) + "-" + ab.substring(3,5);
	System.out.println(ne);
	java.sql.Date dt = java.sql.Date.valueOf(ne); 
	
	try
	{
		
		 con=dbconObj.getDbConnection();
		stmt=con.prepareStatement(querystring);
	    
	
		
		stmt.setDate(1,dt );
		
		rs=stmt.executeQuery();
		
		while(rs.next())
		{
			String movie_name = rs.getString("MOVIE_NAME");
			Date op_date = rs.getDate("OPENING_DATE");
			Date cl_date = rs.getDate("CLOSING_DATE");
			abcd.add(movie_name);
			abcd.add(op_date);
			abcd.add(cl_date);
		}
	}
	catch(SQLException sqex){
		System.out.println(sqex);
		}
	System.out.println("statements executed");
	return(abcd);
			
		}
	}
	

	

