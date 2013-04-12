package com.tcs.utility;
import java.sql.*;

import com.tcs.bean.*;
public class ModelCustomer 
{
public void insertCustomer(Customer cust) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			System.out.println("sddsasd");
			stmt.executeQuery("INSERT INTO g4_customer VALUES('"+cust.getName()+"',"+cust.getAge()+",'"+cust.getGender()+"','"+cust.getAddress()+"','"+cust.getPhoneNo()+"','"+cust.getUsername()+"','"+cust.getPassword()+"')");
			System.out.println("anuj");
			System.out.println("one row inserted ");
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
			}
public void createCustomer(Customer cust) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeQuery("CREATE TABLE g4_Customer (NAME varchar2(50),Age number(3),Gender varchar2(1),Address varchar2(100),Phone_No number(15),Username varchar2(50) primary key, Password varchar2(50) )");
			System.out.println("Table Created");
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
		/*finally{
			stmt.close();
			con.close();
			System.out.println("Connection closed successfully");
		}*/
        

	}


public Boolean checkAvailability(String username) {
	Boolean status=false;
	DbConnection dbconObj=new DbConnection();
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	try
	{
		
		con=dbconObj.getDbConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from g4_customer where username='"+username+"'");
		if(rs.next())
		{
			status=true;
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
    return status;

}


}
