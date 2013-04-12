package com.tcs.utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTheaterTable {

    
    
	public static void main(String[] args) throws SQLException {
		
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
		    
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			String table = "CREATE TABLE G4_Theater(theater_Name varchar2(20),theater_ID number(2) primary key, seat_Capacity number(3), price number(4,2), rating number(1) )";
            stmt.executeUpdate(table);
            System.out.println("Table creation process successfully!");
			}
		catch(SQLException sq){
			System.out.println(sq);
		}
		finally{
			stmt.close();
			con.close();
			System.out.println("Connection closed successfully");
		}
		
	}	
	

	

}