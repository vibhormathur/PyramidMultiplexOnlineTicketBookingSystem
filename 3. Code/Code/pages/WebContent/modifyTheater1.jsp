<%@ page import="java.sql.*,com.tcs.utility.*" %>


<%DbConnection dbconObj=new DbConnection();
Connection con=null;
Statement stmt=null;


int seatcapacity=0;
int rating=0;
int theater_id=Integer.parseInt(request.getParameter("tid"));%>
<html>

<body>
<form name="form" action="ModifyTheaterController?tid=<%= theater_id %>" method="post">
<center>
<table>
<tr>
<td>
<%
try{
	
	con=dbconObj.getDbConnection();
	stmt=con.createStatement();
	
	
	ResultSet rs =(ResultSet) stmt.executeQuery("SELECT seat_capacity,rating FROM G4_THEATER where theater_id="+theater_id);
	while (rs.next()) {
		
		seatcapacity=rs.getInt(1);
		rating=rs.getInt(2);
	}
	
	
}
catch(Exception e)
{
	System.out.println("error1:"+ e.getMessage());
} %>

<tr><td>
Theater Response: </td><td><% out.println(rating);%></td></tr>

<tr><td>
Current seat count:</td><td><%out.println(seatcapacity);%></td></tr>  

<tr><td>
Enter new seat count:&nbsp;</td><td><input type="text" name="newseatcount" /></td></tr>

<tr><td><input type="submit" value="Change Seat Capacity"/></td></tr>

</table>
</center>
</form>
</body>
</html>