 <%@ page import="java.util.*" %>
<html>
<head>
<title>Pyramid - HOME</title>
<script language="JavaScript" src="calendar_us.js">
</script>
	<link rel="stylesheet" href="calendar.css">
	</head>
<body bgcolor="#E9CFEC">

<img src="/pages/img/movie-theater-article.jpg" height="120" width="250" align="left" />
<img src="/pages/img/right_logo.jpg" height="120" width="250" align="right" />
<center><img src="/pages/img/logo.png" /></center><br />

<span style="font-size: 14pt;color:#8D38C9; font-weight: bold;">
     <marquee>Pyramid Multiplex Online Booking</marquee></span><br /><br />
 
 <form name="home" action="/pages/Select_movie" method="post">
<span style="font-size: 14pt;color:#8D38C9;">Search Movies</span>
    <span style="font-family: Georgia; font-size: 24pt;"></span>  
   
    <input type="text" name="testinput" />
	<script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'home',
		// input name
		'controlname': 'testinput'
	});
	</script>	
    <input type="submit" value="Search Now !!!"  />
</form>
<div align="right">
<span style="font-size: 14pt;">
        <%if(session.getAttribute("username")==null)       
        {%><a href="login.jsp">

<span style="font-size: 14pt;color:#8D38C9;font-weight: bold;">Login</span></a>
<span style="font-size: 14pt;color:#8D38C9;font-weight: bold;">
<a href="Register.jsp">Register Now</a></span><%}
        else if(session.getAttribute("type")=="admin")
{%><a href="mysettings.jsp">
<span style="font-size: 14pt;color:#8D38C9;">My Settings</span></a>|
<a href="/pages/LogoutSubmitController">
<span style="font-size: 14pt;color:#8D38C9;">Logout </span></a> <%}
        else if(session.getAttribute("type")=="customer")

{%><a href="myprofile.jsp">
<span style="font-size: 14pt;color:#8D38C9;">My Profile</span></a>|

<a href="/pages/LogoutSubmitController">
<span style="font-size: 14pt;color:#8D38C9;">Logout</span></a><%}%>
</span>
</div>
<br /><br />
<table width=100% height=100%>
<tr>
<td width=20%>
<img src="/pages/img/OCMastroNewsletter_08081.gif" align="left" border="2"/>
</td>
<td width=60%><div id="workspace"><%if((String)request.getAttribute("success")=="success"){%>
	
 <% ArrayList abcd = new ArrayList();
	abcd = (ArrayList)request.getAttribute("arr");
int length = abcd.size();
int i;%>
<form name=form action="bookticket.jsp?yes=1" method="post">
<center><table><tr><td><table border="1">
<tr><td></td><td>Movie Name</td><td>Opening Date</td><td>Closing Date</td></tr>
<%
for(i=1;i<length/3;i++)
{%>
<tr><td>
<% String movie_name = (String)abcd.get((i-1)*3); %>
<input type=radio name="radio" value="<%=movie_name%>"></td>
<%
System.out.println(abcd.get((i-1)*3));%>
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
<input type="submit" value="Book Ticket"/></td></tr>
</table>

</center>
</td></tr></table></center>
</form>
<%} %></div></td>
<td width=20%><img src="/pages/img/submarinoparte000123123.gif" align="right" border="2"/></td></tr>
</table>
<center><img src="/pages/img/header_background.gif" border="2"/></center>
<span style="font-size: 14pt;color:#8D38C9;"><marquee>This site best viewed on resolution 1024 * 768</marquee></span><br /><br />
  
</body>
</html>
