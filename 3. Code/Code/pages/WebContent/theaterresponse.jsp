<% if(session.getAttribute("username")!=null)
{%>
<html>
<body>
<form name="form" action="ResponseController" method="post">
<center>
<table>
<tr>
<td>
<%@ page import="java.sql.*,com.tcs.utility.*" %>
<%
if(request.getAttribute("yes")=="yes")
{%>
<script type="text/javascript">
alert("Your response has been saved");
</script>

<%}	
DbConnection dbconObj=new DbConnection();
Connection con=null;
Statement stmt=null;

int  maxTheaterId=0 ;
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
Select Theater Id: </td><td><select name="tid">
<%for(int i=1;i<=maxTheaterId;i++){%>
<option><%=i%></option>
<%} %>
</select></td></tr>

<tr><td>Rate theater:</td><td> <select name="rate">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
</select></td></tr>
<tr><td>
<input type="submit" value="Save theater response"><br />
</td></tr></table></center>
</form>
<br />
<br />
<br />
</body>
</html>
<%}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%}%>
