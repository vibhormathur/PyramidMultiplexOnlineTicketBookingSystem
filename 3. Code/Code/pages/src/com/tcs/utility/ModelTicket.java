package com.tcs.utility;
import java.sql.*;
import com.tcs.bean.*;

public class ModelTicket 
{
public int insertTicket(int price,String username,String date,String slot,int no,String movie) 
{
	int ticket_id=0;
	int show_id=0;
	
	int seatOccupancy = 0,seatNo=0,movie_id=0;
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt2=null;
		PreparedStatement stmt=null,stmt1=null,stmt3=null;
		ResultSet rs=null,rs1=null,rs2=null;
		try{
			con=dbconObj.getDbConnection();
			stmt3=con.prepareStatement("select movie_id from g4_movie where movie_name='"+movie+"'");
			rs2=stmt3.executeQuery();
			if(rs2.next())
			{
				movie_id=rs2.getInt(1);
			}
			
		}
		catch(Exception e)
		{
		}
		
		try{
			System.out.println("111111");
			con=dbconObj.getDbConnection();
			stmt=con.prepareStatement("select max(ticket_id) from g4_ticket");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				ticket_id=rs.getInt(1)+1;
			}
			else
				ticket_id=1;
		}
		catch(Exception e)
		{
		}
		for(int i=0;i<no;i++)
		{
		try{
			
			con=dbconObj.getDbConnection();
			
			
			System.out.println("2222222");
			stmt1=con.prepareStatement("select show_id,seat_occupancy from g4_show where movie_id="+movie_id+" and show_date=? and slot=? and seat_occupancy<seat_capacity");
			
			String ab=date;
			String ne = ab.substring(6,10) + "-" + ab.substring(0,2) + "-" + ab.substring(3,5);
			System.out.println(ne);
			java.sql.Date dt = java.sql.Date.valueOf(ne); 
			
			
			
			stmt1.setDate(1, dt);
			stmt1.setString(2, slot);
			rs1=stmt1.executeQuery();
			
			if(rs1.next())
			{
				show_id=rs1.getInt(1);
				seatOccupancy=rs1.getInt(2);
			
			seatNo=seatOccupancy+1;
			stmt2=con.createStatement();
			
			System.out.println("33333");
			stmt2.executeQuery("INSERT INTO G4_ticket VALUES("+ticket_id+","+price+",'"+username+"',"+show_id+","+seatNo+")");
			System.out.println("one row inserted ");
			
			stmt2.executeUpdate("update g4_show set seat_occupancy=seat_occupancy+1 where show_id="+show_id);
			}
			else
				ticket_id=0;
			}
		catch(SQLException sqex){
			System.out.println(sqex);
		}
		}
		/*finally{
			stmt.close();
			con.close();
			System.out.println("Connection closed successfully");
		}*/
        return ticket_id;

	}



public void createTicket(Ticket tkt) 
{
		
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt2=null;
		
		try{
			
			con=dbconObj.getDbConnection();
		
			stmt2=con.createStatement();
			stmt2.executeQuery("CREATE TABLE G4_ticket (Ticket_ID NUMBER(10) primary key,Price NUMBER(4,2),username varchar(25),Show_ID NUMBER(10),Seat_No NUMBER(4))");
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







}
