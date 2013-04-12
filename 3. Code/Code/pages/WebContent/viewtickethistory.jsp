<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.tcs.utility.*,java.sql.Connection, java.sql.Statement, java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(session.getAttribute("username")!=null)
{%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pyramid Multiplex</title>
</head>
<body>
 
<form name=form action="viewtickethistory.jsp" method="post">
<center><table><tr><td><center><table border="1">
<tr><td>Ticket ID</td><td>Show Date</td><td>Movie Name</td><td>Seat No.</td><td>Slot</td></tr>
<%		
		DbConnection dbconObj=new DbConnection();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs1=null;
		int maxMovieId=0;
		try{
			String temp_username = (String)session.getAttribute("username");
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			int i=1;
			rs1 =stmt.executeQuery("select t.ticket_id,t.show_id,t.seat_no,m.movie_id,m.movie_name,s.show_id,s.show_date,s.slot from g4_ticket t, g4_show s, g4_movie m where t.username='"+temp_username+"' and s.show_id=t.show_id and m.movie_id=s.movie_id");
			while(rs1.next() && i<11)
			{
				i++;
			int temp_ticket_id = rs1.getInt(1);
			int temp_seat_no = rs1.getInt(3);
			Date temp_date =(Date)rs1.getDate(7);
			String temp_movie_name = rs1.getString(5);
			String temp_slot = rs1.getString(8);
			
			%>
				<tr><td><%out.println(temp_ticket_id); %></td><td><%out.println(temp_date); %></td><td><%out.println(temp_movie_name); %></td><td><%out.println(temp_seat_no); %></td><td><%out.println(temp_slot); %></td></tr>
			<%}
			}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		}


%>

</table>
</center>
</td></tr></table></center>
</form>
</body>
</html>
<%}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%}%>
