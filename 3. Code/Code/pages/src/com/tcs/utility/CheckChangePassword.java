package com.tcs.utility;

import java.sql.*;

public class CheckChangePassword {
	public Boolean passwordchanger(String username,String password) 
	{
		
	DbConnection dbconObj=new DbConnection();
	Connection con=null;
	Statement stmt=null;
	boolean status=false;
	try{
	    
		con=dbconObj.getDbConnection();
		stmt=con.createStatement();
		
		String query = "SELECT PASSWORD FROM G4_CUSTOMER WHERE USERNAME = '"+username+"'" ;
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next())
		{
			status =true;
		}
			
	}
	catch(SQLException sqex){
		System.out.println(sqex);
	}
	return status;
	
	}
	
	
	
	public void updatepass(String username,String password) 
	{
		
	DbConnection dbconObj=new DbConnection();
	Connection con=null;
	Statement stmt=null;
	
	try{
	    
		con=dbconObj.getDbConnection();
		stmt=con.createStatement();
		
		String query = "update G4_CUSTOMER set password = '"+password+ "' WHERE USERNAME = '"+username+"'" ;
		stmt.executeUpdate(query);
			
	}
	catch(SQLException sqex){
		System.out.println(sqex);
	}
	
	
	}
}
