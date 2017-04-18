<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Availability of Doctors</title>
</head>
<body>
<h2 style="color: #CD5C5C" align="center">Available Doctor SLots</h2>
<c:if test="${not empty doctorSlotList}">

		
		<table border="1" style="border-color: navy;position: absolute;left:500px;top:180px">
		<tr>
				<td>DNAME</td>
				<td>SPECIALAIZATION</td>
				<td>SLOT</td>
				<td>ADD SLOT</td>
				
		</tr>
			<c:forEach var="listValue" items="${doctorSlotList}" varStatus="status">
				 <tr>
      				
      				<td><c:out value="${listValue.dname}" /></td> 
      				<td><c:out value="${listValue.specialaization}" /></td> 
       				<td><c:out value="${listValue.slotdate}" /></td>
       				<td><a
                            href="<c:url value="bookslot">  
                    <c:param name="duname" value="${listValue.duname}"/> 
                     <c:param name="dname" value="${listValue.dname}"/> 
                     <c:param name="specialaization" value="${listValue.specialaization}"/> 
                     <c:param name="slotdate" value="${listValue.slotdate}"/>
        			</c:url>  ">ADD SLOT</a></td> 
       				
     			</tr>
			</c:forEach>
			 
		</table>

	</c:if>

</body>
</html>