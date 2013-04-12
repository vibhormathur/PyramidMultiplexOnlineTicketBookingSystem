<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,java.sql.*,com.tcs.utility.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(session.getAttribute("username")!=null)
	{
	DbConnection dbconObj=new DbConnection();
	Connection con=null;
	Statement stmt=null;
	int tid=Integer.parseInt(request.getParameter("tid"));
	try
	{
		
		con=dbconObj.getDbConnection();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select movie_name,opening_date,closing_date from g4_movie where sysdate>opening_date and sysdate<closing_date and theatre_id="+tid);
		%><html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		</head>
		<body>
		 <%
		if(rs.next())
		{%>
		<center><table border="1">
		<tr><td>Movie Name</td><td><%=rs.getString(1) %></td></tr>
		<tr><td>Opening Date</td><td><%=rs.getDate(2) %></td></tr>
		<tr><td>Closing Date</td><td><%=rs.getDate(3) %></td></tr>
		
		</table>



		</center>

		</body>
		</html>
		<%
		}
		else
			out.println("<span style='font-size: 14pt;color:red; font-weight: bold;'><center><table><tr><td>No Movie available today</td></tr></table></center></span>");
	}
	catch(SQLException sqex)
	{
		System.out.println(sqex);
	}
	}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%}%>