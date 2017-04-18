<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Availability of Doctors</title>
</head>
<body style="margin:0;background-color: #1c478c;color: #fff">
<h1 style="margin:0;padding: 5px;background-color: #333;color: #fff" align="center">Available Docotors list</h1>
<c:if test="${not empty DoctorList}">

		
		<table border="1" style="border-color: navy; position: absolute;left: 500px;top: 300px" >
		<thead>
		<tr>
				<th>DUNAME</th>
				<th>PASSWORD</th>
				<th>DNAME</th>
				<th>SEX</th>
				<th>SSN</th>
				<th>SALARY</th>
				<th>SPECIAL</th>
				<th>ACTION</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${DoctorList}" varStatus="status">
				 <tr>
      				 <td><c:out value="${listValue.duname}" /></td>
       				<td><c:out value="${listValue.dpassword}" /></td>
      				 <td><c:out value="${listValue.dname}" /></td>
       				<td><c:out value="${listValue.sex}" /></td>
       				<td><c:out value="${listValue.ssn}" /></td>
       				<td><c:out value="${listValue.dsalary}" /></td>
       				<td><c:out value="${listValue.specialaization}" /></td>
       				<td><a href="<c:url value='removedoctor/${DoctorList[status.index].duname}' />"  >Drop</a></td>
       				
     			</tr>
			</c:forEach>
			 </tbody>
		</table>

	</c:if>

</body>
</html>