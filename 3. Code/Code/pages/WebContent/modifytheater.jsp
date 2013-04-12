
<html>

<body>
<form name="form" action="modifyTheater1.jsp" method="post">
<center>
<table>
<tr>
<td>
<%@ page import="java.sql.*,com.tcs.utility.*" %>
<%
if(request.getAttribute("yes")=="yes")
{%>
<script type="text/javascript">
alert("Your no. of seats has been modified.");
</script>

<%}	
DbConnection dbconObj=new DbConnection();
Connection con=null;
Statement stmt=null;

int  maxTheaterId=0 ;
int seatcapacity=0;
int rating=0;
try{
	
	con=dbconObj.getDbConnection();
	stmt=con.createStatement();
	ResultSet rs =(ResultSet) stmt.executeQuery("SELECT MAX(theater_ID) FROM G4_THEATER");
	
	while (rs.next()) {
		maxTheaterId=rs.getInt(1);
		
	}
	
}
catch(Exception e)
{
	System.out.println("error1:"+ e.getMessage());
} %>
Select Theater Id: </td><td><select name="tid" ">
<%for(int i=1;i<=maxTheaterId;i++){%>
<option><%=i%></option>
<%} %>
</select></td></tr>

<tr><td><input type="submit" value="Submit"/></td></tr>

</table>
</center>
</form>
</body>
</html>