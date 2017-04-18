<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Availability of Doctors</title>
<link rel="stylesheet" type="text/css" href="styles.css">

<style type="text/css">


.myTableStyle
        {
           position:absolute;
           top:30%;
           left:30%;
           }
</style>
</head>
<body>

<h2 style="color: #CD5C5C" align="center"> Your Slots</h2>
<c:if test="${not empty doctorSlotList}">
			
		
		<table class="myTableStyle" border="1" style="border-color:#FFDEAD;">
		<thead>
		<tr style="background-color: #808000" >
				<th >SLOT</th>
				
		</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${doctorSlotList}" varStatus="status">
				 <tr>
      				 
       				<td><c:out value="${listValue.slotdate}" /></td>
       				<td><a href="<c:url value='removedoctor/${doctorSlotList[status.index].duname}' />"  >Drop</a></td>
       				
     			</tr>
			</c:forEach>
			</tbody>
			 
		</table>

	</c:if>

</body>
</html>