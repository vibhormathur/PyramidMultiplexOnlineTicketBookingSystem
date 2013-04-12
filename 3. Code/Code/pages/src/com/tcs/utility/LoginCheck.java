package com.tcs.utility;
import java.sql.*;
import java.util.ArrayList;
public class LoginCheck 
{
	
public ArrayList<Object> isValidUser(String username,String password) 
{
	ArrayList<Object> array=new ArrayList<Object>();
		Boolean status=false;
		String type="";
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from g4_administrator where username='"+username+"' and password='"+password+"'");
			if(rs.next())
			{
				status=true;
				type="admin";
				array.add(status);
				array.add(type);
			}
		}
		catch(SQLException sqex)
		{
			System.out.println(sqex);
		}
		if(status==false)
		{
			try
			{
				
				con=dbconObj.getDbConnection();
				stmt=con.createStatement();
				rs=stmt.executeQuery("select * from g4_customer where username='"+username+"' and password='"+password+"'");
				if(rs.next())
				{
					status=true;
					type="customer";
					array.add(status);
					array.add(type);
				}
			}
			catch(SQLException sqex)
			{
				System.out.println(sqex);
			}
			/*finally{
				stmt.close();
				con.close();
				System.out.println("Connection closed successfully");
			}*/
		}
		if (status==false)
		{
			array.add(status);
			array.add(type);
		}
        return array;

	}
}
