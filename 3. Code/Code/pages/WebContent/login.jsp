<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Pyramid Multiplex</title>
</head>
<body>
<center>
<br><br><br><br>
<table>

<tr>
<td >

<form action="/pages/LoginSubmitController" method="post" name="form">

<fieldset >
<legend>Sign in with your Pyramid Account</legend>
<center>
<table >
<tr>
<td>
<br>
Username:
</td>
<td colspan=1>
<input type=text name=username />
</td>
</tr>
<tr>
<td>
Password:

</td>
<td colspan=1>
<input type=password name=password />
</td>
</tr>

<tr>
<td></td>
<td>
<br>
<input type=submit name=submit value="Sign In">
</td>
</tr>

</table>
<%String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<table>
<tr>
<td><font color="red">
<%out.println((String)request.getAttribute("message"));
} %></font>
</td>
</tr>
</table>
</center>
</fieldset>

</form>

</td></tr>
</table>
</center>



</body>
</html>
