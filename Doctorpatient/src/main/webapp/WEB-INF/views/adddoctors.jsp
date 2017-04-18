<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Doctors Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2 style="color: #CD5C5C" align="center">Doctors  Registration Form</h2>
    <h3 style="color: #CD5C5C" align="center">${exception}</h3>
  
    <form:form method="post" modelAttribute="doctoraddform" action="doctoraddform">
       
        
        <table style="position: absolute;left:500px;top:250px">
        
        	<tr>
                <td><label for="duname">Doctor User Name: </label> </td>
                <td><form:input path="duname" id="duname"/></td>
                <td><form:errors path="duname" cssClass="error"/></td>
            </tr>
            <tr>
				<td>Password :</td>
				<td><form:password path="dpassword" />
				</td>
				<td><form:errors path="dpassword" cssClass="error" />
				</td>
			</tr>
            <tr>
                <td><label for="dname">Doctor Name: </label> </td>
                <td><form:input path="dname" id="name"/></td>
                <td><form:errors path="dname" cssClass="error"/></td>
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
                <td><label for="dsalary">Salary: </label> </td>
                <td><form:input path="dsalary" id="dsalary"/></td>
                <td><form:errors path="dsalary" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="specialaization">Specialaization: </label> </td>
                <td><form:input path="specialaization" id="specialaization"/></td>
                <td><form:errors path="specialaization" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="role">ROLE: </label> </td>
                <td><form:select path="role" id="role">
                	 <form:option value="ADMIN">ADMIN</form:option>
   					<form:option value="DOCTOR">DOCTOR</form:option>
                 </form:select>
                
                </td>
                <td><form:errors path="role" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    
                            <input type="submit" value="Register"/>

                </td>
            </tr>
        </table>
    </form:form>
   
</body>
</html>