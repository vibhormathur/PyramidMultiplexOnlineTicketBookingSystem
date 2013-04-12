
<%@ page import="java.util.*,com.tcs.utility.*,java.sql.Connection, java.sql.Statement, java.sql.ResultSet" %>
<% if(session.getAttribute("username")!=null)
{


if(request.getParameter("yes")!=null)
{	%>
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
<td width=60%><div id="workspace"><html>

<head>
<script language="JavaScript" src="calendar_us.js"></script>
	<link rel="stylesheet" href="calendar.css">
</head>

<script type="text/javascript">
function total()
{
	var total=document.form.person.value*250;
	document.getElementById("total").innerHTML=total;
}
</script>
<body>
<%

if(request.getAttribute("msgmovie")=="yes")
{
	System.out.println("fasjgdg");
	int ticket=Integer.parseInt((String)request.getAttribute("ticket"));
	DbConnection dbconObj=new DbConnection();
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs1=null;
	
	%>
		<script type="text/javascript">
		alert("Your Ticket ID is "+<%=ticket%>+"and seat nos. are:");
		</script>
		<%
		try{
			con=dbconObj.getDbConnection();
		stmt=con.createStatement();
		
		rs1 =stmt.executeQuery("select seat_no from g4_ticket where ticket_id="+ticket);
		int i=0;
		int[] seat_no=new int[5];
		while(rs1.next() )
		{
			System.out.println(ticket);
			 seat_no[i]= rs1.getInt(1);
			 i++;
		}
		%>
		<script type="text/javascript">
		alert(<%for(int j=0;j<i;j++){%><%=seat_no[j]%><%}%>);
		</script><%
		}
	catch(Exception e)
	{
		System.out.println("error1:"+ e.getMessage());
	}


}%>
<fieldset>
<legend>Book a ticket:</legend>
<form name=form method="post" action="/pages/BookTicketController">


<table>
<%
if(request.getAttribute("msgmovie")!=null && request.getAttribute("msgmovie")!="yes")
{%>

<tr>
<td></td>
<td ><font color="red">
<%out.println((String)request.getAttribute("msgmovie"));
} %>
</font>
</td>
</tr>
<tr>
<td>
Enter Movie Name:
</td>
<td>
<%String radio=request.getParameter("radio") ;
if(radio==null)
{
	radio="";
	System.out.println(radio);
}
%>
<input type="text" size="20" name="movie" value="<%=radio %>">
</td>
</tr>
<tr>
<td>
Select date:
</td>
<td>
<input type="text" name="testinput" />
	<script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'form',
		// input name
		'controlname': 'testinput'
	});

	</script>
</td>
</tr>
<tr>
<td>
Select Show:
</td>
<td>
<input type="radio" name="group1" value="A"> Afternoon (3:00 PM - 6:00 PM)<br>
<input type="radio" name="group1" value="E" checked> Evening (6:00 PM - 9:00 PM)<br>
<input type="radio" name="group1" value="N"> Night (9:00 PM - 12:00 AM)
</td>
</tr>
<tr>
<td>
Enter person count:
</td>
<td>
<select onchange="total();" name="person" >
  <option>1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
</select>
</td>
</tr>
<tr>
<td>
Price per ticket(in Rs.): 
</td>
<td>
250
</td>
</tr>
<tr>
<td>
Total cost(in Rs.):
</td>
<td>
<div id=total>250</div>
</td>
</tr>
<tr>
</tr>
<tr>
<td>
<input type="submit" value="Confirm and Book"/>
</td>
</tr>
</Table>
</form>
</fieldset>

</body>
</html></div></td>
<td width=20%><img src="/pages/img/submarinoparte000123123.gif" align="right" border="2"/></td></tr>
</table>
<center><img src="/pages/img/header_background.gif" border="2"/></center>
<span style="font-size: 14pt;color:#8D38C9;"><marquee>This site best viewed on resolution 1024 * 768</marquee></span><br /><br />
  
</body>
</html>

<%
}
else
{%>
	<html>

	<head>
	<script language="JavaScript" src="calendar_us.js"></script>
		<link rel="stylesheet" href="calendar.css">
	</head>

	<script type="text/javascript">
	function total()
	{
		var total=document.form.person.value*250;
		document.getElementById("total").innerHTML=total;
	}
	</script>
	<body>
	<%

	if(request.getAttribute("msgmovie")=="yes")
	{
		System.out.println("fasjgdg");
		int ticket=Integer.parseInt((String)request.getAttribute("ticket"));
		DbConnection dbconObj=new DbConnection();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs1=null;
		
		%>
			<script type="text/javascript">
			alert("Your Ticket ID is "+<%=ticket%>+"and seat nos. are:");
			</script>
			<%
			try{
				con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			
			rs1 =stmt.executeQuery("select seat_no from g4_ticket where ticket_id="+ticket);
			int i=0;
			int[] seat_no=new int[5];
			while(rs1.next() )
			{
				System.out.println(ticket);
				 seat_no[i]= rs1.getInt(1);
				 i++;
			}
			%>
			<script type="text/javascript">
			alert(<%for(int j=0;j<i;j++){%><%=seat_no[j]%><%}%>);
			</script><%
			}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		}


	}%>
	<fieldset>
	<legend>Book a ticket:</legend>
	<form name=form method="post" action="/pages/BookTicketController">


	<table>
	<%
	if(request.getAttribute("msgmovie")!=null && request.getAttribute("msgmovie")!="yes")
	{%>

	<tr>
	<td></td>
	<td ><font color="red">
	<%out.println((String)request.getAttribute("msgmovie"));
	} %>
	</font>
	</td>
	</tr>
	<tr>
	<td>
	Enter Movie Name:
	</td>
	<td>
	<%String radio=request.getParameter("radio") ;
	if(radio==null)
	{
		radio="";
		System.out.println(radio);
	}
	%>
	<input type="text" size="20" name="movie" value="<%=radio %>">
	</td>
	</tr>
	<tr>
	<td>
	Select date:
	</td>
	<td>
	<input type="text" name="testinput" />
		<script language="JavaScript">
		new tcal ({
			// form name
			'formname': 'form',
			// input name
			'controlname': 'testinput'
		});

		</script>
	</td>
	</tr>
	<tr>
	<td>
	Select Show:
	</td>
	<td>
	<input type="radio" name="group1" value="A"> Afternoon (3:00 PM - 6:00 PM)<br>
	<input type="radio" name="group1" value="E" checked> Evening (6:00 PM - 9:00 PM)<br>
	<input type="radio" name="group1" value="N"> Night (9:00 PM - 12:00 AM)
	</td>
	</tr>
	<tr>
	<td>
	Enter person count:
	</td>
	<td>
	<select onchange="total();" name="person" >
	  <option>1</option>
	  <option>2</option>
	  <option>3</option>
	  <option>4</option>
	  <option>5</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	Price per ticket(in Rs.): 
	</td>
	<td>
	250
	</td>
	</tr>
	<tr>
	<td>
	Total cost(in Rs.):
	</td>
	<td>
	<div id=total>250</div>
	</td>
	</tr>
	<tr>
	</tr>
	<tr>
	<td>
	<input type="submit" value="Confirm and Book"/>
	</td>
	</tr>
	</Table>
	</form>
	</fieldset>

	</body>
	</html>
<%}

}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%
response.sendRedirect("login.jsp");	
}
%>