package com.tcs.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.tcs.bean.*;

public class InsertTheaterTable {
	static int  maxTheaterId ;
	
	public static void insertTheaterTable(Theater th) throws SQLException {
	    
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
	
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			ResultSet rs =(ResultSet) stmt.executeQuery("SELECT MAX(theater_ID) FROM G4_THEATER");
			
			while (rs.next()) {
				maxTheaterId=rs.getInt(1);
			}
			maxTheaterId+=1;
			th.setTheater_ID(maxTheaterId);
		}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		}
		try
		{
			stmt.executeQuery("INSERT INTO G4_Theater(theater_ID , seat_Capacity , price , rating ) VALUES("+th.getTheater_ID()+","+th.getSeat_Capacity()+","+th.getPrice()+","+th.getRating()+")");
		
			System.out.println("one row inserted ");
			
		con.commit();
			}
		catch(SQLException sqex){
			System.out.println("error2:"+sqex);
		}
		finally{
			stmt.close();
			con.close();
			System.out.println("Connection closed successfully");
		}
   
	}
	

	 


}