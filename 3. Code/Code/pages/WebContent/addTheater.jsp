<% if(session.getAttribute("username")!=null)
{%>
<html>
<head>
<script type="text/javascript">

function checknumber(){
	var x=document.form.seat_capacity.value
	var anum=/(^\d+$)|(^\d+\.\d+$)/
	if (anum.test(x))
	{
		if(x<999)
			testresult=true;
		else 
		{
			alert("Please input a valid number!")
			testresult=false;
		}
	}
	else{
	alert("Please input a valid number!")
	testresult=false;
	}
	return (testresult);
	}

function checkSeatCapacity(){
	if (document.layers||document.all||document.getElementById)
	{
		return checknumber();
		//return ValidateForm();
	}
	else
	return true;
	}


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

function validateCapacity(){
	var Capacity=document.form.seat_Capacity
	
	if ((Capacity.value==null)||(Capacity.value=="")){
		alert("Please Enter your Number")
		Capacity.focus()
		return false
	}
	if (checkCapacity(Capacity.value)==false){
		alert("Please Enter a Valid Number")
		Capacity.value=""
		Capacity.focus()
		return false
	}
	return true
 }


function checkCapacity(strCapacity){
strCapacity=trim(strCapacity);
return (isInteger(s) && s.length <= 3);
}

function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (c != " ") returnString += c;
    }
    return returnString;
}

function isInteger(s)
{   var i;
	if(s.length>10)
		return false;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
	
function validateEmpty() {
    error =true;
 	fld=document.form;
    if (fld.theater_Name.value == "" || fld.seat_Capacity.value == "" || fld.price.value == "" ) 
        { 
   		   alert("The required field has not been filled in.\n");
        	error=false;
    	}
    	    return error;  
}
</script>
<title>Add theater - Pyramid Multiplex</title>
</head>

<body>


<center>
<table width=50%><tr><td>
<form name="form"  onSubmit="return (validateEmpty() && checkSeatCapacity() && validateCapacity()) "  method="post" action="AddTheaterController">
<br/><br/><br/><br/><br/>
<fieldset >
<legend>Please provide the following information :</legend>
<table><tr><td>Theater Name:</td><td><input type="text" name="theater_Name" /></td></tr> 

<tr><td>Seat Capacity:  </td><td><input type="text" name="seat_Capacity" />   </td></tr>                                                                                                                                                                                                                                                          

 </table>

<center><table><tr><td><input type=submit value="Add Theater" /></td></tr></table></center>
</fieldset>
</form></td></tr></table>
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