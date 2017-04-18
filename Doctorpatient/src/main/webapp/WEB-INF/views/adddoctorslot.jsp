<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Insert title here</title>
<style type="text/css">

 .myTableStyle
        {
           position:absolute;
           top:30%;
           left:30%;
           }
</style>
</head>

<body style="background-color: #BDB76B">


  <form method="post" action="adddoctorslotform">
        		
              <input type="hidden" name="duname" id="duname" />
              <input type="hidden" name="dname" id="dname" />
              <input type="hidden" name="specialaization" id="specialaization" />

		<table class="myTableStyle"  border="1" style="border-color: #90EE90;">

			<tr>
				<td><label for="slotdate">Add SLOT Date: </label></td>
				<td><input type="datetime-local" name="slotdate" /></td>


			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
		
	</form>


</body>
</html>