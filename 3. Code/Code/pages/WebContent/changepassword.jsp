<% if(session.getAttribute("username")!=null)
{%>
<html>
<body>
  <div>

  <br />
  <br />
  <form name=form action="/pages/ChangePasswordController" method="post">
  <fieldset>
  <legend>Change Password</legend>
  <table><tr><td>Old Password:</td><td>
  <input type="password" name="old_Password" /></td></tr><tr><td>
  New Password:</td><td>
  <input type="password" name="new_Password" />
</td></tr><tr><td>
  Confirm New Password:</td><td>
  <input type="password" name="confirm_Password" />
  </td></tr><tr><td>
  
  <input type=submit value="Save" /></td></tr>
  <%String message=(String)request.getAttribute("msgchangepwd");
if(message!=null)
{%>

<tr>
<td><font color="red">
<%out.println((String)request.getAttribute("msgchangepwd"));
} %></font>
</td>
</tr>
</table></fieldset></form></div>
</body>
</html>
<%}
else
{%>
	<script type="text/javascript">
	alert("Login to continue !!!");
	</script>
	
	<%}%>