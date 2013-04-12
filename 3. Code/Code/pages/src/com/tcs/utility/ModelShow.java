package com.tcs.utility;
import java.sql.*;
import com.tcs.bean.*;

public class ModelShow 
{
public void insertShow(Show show) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeQuery("INSERT INTO G4_show VALUES('"+show.getShow_ID()+"',"+show.getShow_Date()+",'"+show.getSlot()+"','"+show.getSeat_Capacity()+"','"+show.getSeat_Occupancy()+"','"+show.getMovie_ID()+"')");
			System.out.println("one row inserted ");
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
public void createShow(Show show) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeQuery("CREATE TABLE G4_show (Show_ID NUMBER(4),show_Date DATE,Slot varchar2(15),Seat_Capacity number(5),Seat_Occupancy number(5),Movie_ID number(5))");
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
}
