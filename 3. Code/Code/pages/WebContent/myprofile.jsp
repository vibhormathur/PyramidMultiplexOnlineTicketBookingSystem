<% if(session.getAttribute("username")!=null)
{%>
<html>
<head>
<title>My Profile</title>
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

<div align="right">
<span style="font-size: 14pt;">
       <%
        if(session.getAttribute("type")=="customer")

{%>Welcome <%out.println(session.getAttribute("username")); %> |

<a href="/pages/LogoutSubmitController">
<span style="font-size: 14pt;color:#8D38C9;">Logout</span></a><%}%>
</span>
</div>
<br />
<br/>
<center><input type="button" onClick="document.getElementById('workspace').innerHTML='&lt;iframe src=&quot;bookticket.jsp&quot; width=&quot;100%&quot; height=&quot;500px&quot; scrolling=&quot;no&quot; frameborder=&quot;no&quot;&gt;&lt;/iframe&gt;'" value="Book Ticket">  <input type="button" onClick="document.getElementById('workspace').innerHTML='&lt;iframe src=&quot;viewtickethistory.jsp&quot; width=&quot;100%&quot; height=&quot;500px&quot; scrolling=&quot;no&quot; frameborder=&quot;no&quot;&gt;&lt;/iframe&gt;'" value="Ticket History"> <input type="button" onClick="document.getElementById('workspace').innerHTML='&lt;iframe src=&quot;theaterresponse.jsp&quot; width=&quot;100%&quot; height=&quot;500px&quot; scrolling=&quot;no&quot; frameborder=&quot;no&quot;&gt;&lt;/iframe&gt;'" value="Review Theater"><input type="button" onClick="document.getElementById('workspace').innerHTML='&lt;iframe src=&quot;changepassword.jsp&quot; width=&quot;100%&quot; height=&quot;500px&quot; scrolling=&quot;no&quot; frameborder=&quot;no&quot;&gt;&lt;/iframe&gt;'" value="Change Password">  
</center><br />
<table width=100% height=100%>
<tr>
<td width=20%>
<img src="/pages/img/OCMastroNewsletter_08081.gif" align="left" border="2"/>
</td>
<td width=60%><div id="workspace"></div></td>
<td width=20%><img src="/pages/img/submarinoparte000123123.gif" align="right" border="2"/></td></tr>
</table>
<br /><br />


<br /><br /><br /><br /><br /><br />
<center><img src="/pages/img/header_background.gif" border="2"/></center>
<span style="font-size: 14pt;color:#8D38C9;"><marquee>This site best viewed on resolution 1024 * 768</marquee></span><br /><br />
  </form>
</body>
</html>

<%}
else
{response.sendRedirect("login.jsp");}%>
