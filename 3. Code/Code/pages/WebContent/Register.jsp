<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT LANGUAGE="JavaScript">

function validate(){

var digits="0123456789"
var digits1="0123456789@!#$%^&*()_-?`~,.;:'"



var temp
if (document.form.Name.value=="") {
alert("Please enter Name!")
return false
}

if (document.form.gender.value=="") {
	alert("Please select gender!")
	return false
	}


for (var i=0;i<document.form.Name.value.length;i++)
{
temp=document.form.Name.value.substring(i,i+1)
if (digits1.indexOf(temp)!=-1){
alert("Invalid Name")
return false
      }
  }

if (document.form.age.value=="") {
alert("Invalid Age !")
return false
}
for (var i=0;i<document.form.age.value.length;i++){
temp=document.form.age.value.substring(i,i+1)
if (digits.indexOf(temp)==-1){
alert("Invalid Age !")
return false
      }
   }
if(document.form.age.value.length>2)
{
alert("Invalid Age");
return false;
}


if (document.form.address.value=="") {
	alert("Please enter address!")
	return false
	}




if (document.form.phno.value==""||document.form.phno.value.length!=10) {
alert("Invalid phone number !")
return false
}
for (var i=0;i<document.form.phno.value.length;i++){
temp=document.form.phno.value.substring(i,i+1)
if (digits.indexOf(temp)==-1){
alert("Invalid Phone Number !")
return false
      }
   }

if (document.form.username.value=="") {
	alert("Please enter username!")
	return false
	}

if (document.form.password.value=="") {
	alert("Please enter password!")
	return false
	}
return true
}




</SCRIPT>
<title>Register </title>
</head>
<body>
<center>

<table  width="50%" height="50%" >

<tr>
<td >

<form name="form" onSubmit="return validate() " action="/pages/RegisterSubmitController" method="post">
<fieldset >
<legend><b>Register</b></legend>
<table >
<tr>
<td>
Enter Name:
</td>
<td colspan=1>
<input type=text name=Name />
</td>
</tr>
<tr>
<td>
Enter Age:
</td>
<td colspan=1>
<input type=text name=age />
</td>
</tr>
<tr>
<td>
Enter Gender:
</td>
<td>
<input type="radio" name="gender" value="m" /> Male
<input type="radio" name="gender" value="f" /> Female
</td>
</tr>
<tr>
<td >
Enter Address:
</td>
<td colspan=1>
<textarea rows="2" cols="21" name="address">

</textarea>
</td>
</tr>
<tr>
<td>
Enter Contact no.:
</td>
<td colspan=1>
<input type=text name=phno />
</td>
</tr>
<tr>
<td>
Enter Username:
</td>
<td colspan=1>
<input type=text name=username />
</td>
</tr>
<%String message=(String)request.getAttribute("msg");
if(message!=null)
{%>

<tr>
<td></td>
<td ><font color="red">
<%out.println((String)request.getAttribute("msg"));
} %></font>
</td>
</tr>
<tr>
<td>

Enter Password:
</td>
<td colspan=1>
<input type=password name=password />
</td>
</tr>
<tr>
<td></td>
<td>
<br/>
<input type=submit name=submit value="Register">
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