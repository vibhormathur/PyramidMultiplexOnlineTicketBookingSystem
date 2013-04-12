
<% if(session.getAttribute("username")!=null)
{%>
<html>
<head>
<script language="JavaScript" src="calendar_us.js"></script>
	<link rel="stylesheet" href="calendar.css">
<title>Add Movie</title>
</head>
<body>
<center>
<table  width="50%" height="50%" >
<tr>
<td >
<form name="Add Movie" action="/pages/AddMovieController" method="post">
<fieldset >
<legend><b>New Movie</b></legend>
<table >
<tr>
<td>
Movie Name:
</td>
<td colspan=1>
<input type=text name="name" />
</td>
</tr>
<tr>
<td>
Director:
</td>
<td colspan=1>
<input type=text name="director" />
</td>
</tr>
<tr>
<td >
Language:
</td>
<td colspan=1>
<input type=text name="language">
</td>
</tr>

<tr>
<td>
Theater Id:
</td>
<td colspan=1>
<input type=text name="theater_id" />
</td>
</tr><tr>
<td>
<br/>
<input type=submit name=submit value="Submit">
</td>
</tr>
</table>
</fieldset>
</form>
</td></tr>
</table>
</center>
</body>
</html>
<%}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%}%>