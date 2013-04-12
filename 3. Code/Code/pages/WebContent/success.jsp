<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(session.getAttribute("username")!=null)
{%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <% ArrayList abcd = new ArrayList();
	abcd = (ArrayList)request.getAttribute("arr");
int length = abcd.size();
int i;%>
<form name=form action="bookticket.jsp" method="post">
<center><table><tr><td><table border="1">
<tr><td></td><td>Movie Name</td><td>Opening Date</td><td>Closing Date</td></tr>
<%
for(i=1;i<length/3;i++)
{%>
<tr><td>
<% String movie_name = (String)abcd.get((i-1)*3); %>
<input type=radio name="radio" value=<%=movie_name%>></td>
<%System.out.println(abcd.get((i-1)*3));%>
<%
for(int j=(i-1)*3;j<3*i;j++)
{%>

<td>

<%=abcd.get(j) %></input>
</td>

<%
}%>
</tr>
<%
}%>
</table>
<center>
<table>
<tr><td>
<input type="submit" value="Submit"/></td></tr>
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
