<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="tablesstyles.css">
<style type="text/css">

.myTableStyle
        {
           position:absolute;
           top:40%;
           left:30%;
           }
</style>
</head>
<body>
<c:if test="${not empty slotinfolist}">

		
		<table class="myTableStyle" border="1" style="border-color:#FFDEAD;" >
		<thead>
		<tr style="background-color: #808000">
				<th>PANME</th>	
				<th>NOTES</th>	
		</tr>
		</thead>
		<tbody>
		<form:form modelAttribute="patienthistory" action="patienthistory">
			<c:forEach var="listValue" items="${slotinfolist}" varStatus="status">
				 <tr>
   					 
       			    <form:hidden path="duname" value="${listValue.duname}"  />
       				<form:hidden path="dname" value="${listValue.dname}" />
       				<td><form:input path="pname"  value="${listValue.panme}"   readonly="readonly"  /></td>
       				<form:hidden path="slotdate"  value="${listValue.slotdate}"/>
       				<td><form:textarea path="notes" /></td>
       				<td><input type="submit" value="SUBMIT">
       				
       				
     			</tr>
			</c:forEach>
			</form:form>
			</tbody>
			 
		</table>

	</c:if>

</body>
</html>