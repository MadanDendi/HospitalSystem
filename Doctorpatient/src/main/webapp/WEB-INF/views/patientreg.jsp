<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<script type="text/javascript"></script>
<style type="text/css">
<style>
 
    .error {
        color: red;
    }
</style>


</head>
<body style="background-color:#90EE90">
 

 
    <h2 align="center" style="color: #CD5C5C">Patient Registration Form</h2>
    <h1 style="color: red">${exception}</h1>
  
    <form:form method="post" modelAttribute="patientadd" action="patientadd">
        
        <form:hidden path="role" id="role"/>
        <table style="position: absolute; left: 500px;top: 200px">
        
        	<tr>
                <td><label for="puname">User Name: </label> </td>
                <td><form:input path="puname" id="puname"/></td>
                <td><form:errors path="puname" cssClass="error"  /></td>
            </tr>
            <tr>
				<td>Password :</td>
				<td><form:password path="ppassword" />
				</td>
				<td><form:errors path="ppassword" cssClass="error" />
				</td>
			</tr>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            
            <tr>
				<td>Sex :</td>
				<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
					path="sex" value="F" />Female</td>
				<td><form:errors path="sex" cssClass="error" /></td>
			</tr>
       
     
            <tr>
                <td><label for="ssn">SSN: </label> </td>
                <td><form:input path="ssn" id="ssn"/></td>
                <td><form:errors path="ssn" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    
                            <input type="submit" value="Register"/>

                </td>
            </tr>
        </table>
    </form:form>
   
</body>