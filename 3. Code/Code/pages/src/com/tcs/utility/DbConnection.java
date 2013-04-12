package com.tcs.utility;

import java.sql.*;

public class DbConnection 
{
	public Connection getDbConnection()
	{
		Connection con=null;
		try
		{
			//System.out.println("hello");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("hello123");
			String url="jdbc:oracle:thin:@10.10.43.250:1522:edison1";
			con=DriverManager.getConnection(url,"HA18user3","tcshld");   
		}
		catch(Exception e)
		{
			System.out.println("error12:"+e.getMessage());
		}
		return con;
		
	}
	
}

