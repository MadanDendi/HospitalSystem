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
        color: #ff0000;
    }
</style>


</head>
<body style="background-color:#90EE90">
 

 
    <h2>Organ Donor Registration Form</h2>
    <h1 style="color: red">${exception}</h1>
  
    <form:form method="post" modelAttribute="organdonorreg" action="organdonorreg">
        
        <table>
        
            <tr>
                <td><label for="oname">Name: </label> </td>
                <td><form:input path="oname" id="oname"/></td>
                <td><form:errors path="oname" cssClass="error"/></td>
            </tr>
            
            <tr>
				<td>Sex :</td>
				<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
					path="sex" value="F" />Female</td>
				<td><form:errors path="sex" cssClass="error" /></td>
			</tr>
       
     
            <tr>
                <td><label for="mobile">Mobile </label> </td>
                <td><form:input path="mobile" id="mobile"/></td>
                <td><form:errors path="mobile" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="email">E-Mail</label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            
            
             <tr>
                <td><label for="bloodgroup">BloodGroup</label> </td>
                <td><form:select path="bloodgroup">
  						
 						<form:option value="A+">A+</form:option>
 						<form:option value="B+">B+</form:option>
 						<form:option value="A-">A-</form:option>
 						<form:option value="B-">B-</form:option>
 						<form:option value="AB+">AB+</form:option>
 						<form:option value="AB-">AB-</form:option>
 						<form:option value="O+">O+</form:option>
 						<form:option value="O-">O-</form:option>
  						
					</form:select></td>
                <td><form:errors path="bloodgroup" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="organ">OrganDonate</label> </td>
                <td> <form:checkbox path="organ" value="Kidney" />Kidney
                      <form:checkbox path="organ" value="Lungs" />Lungs
                       <form:checkbox path="organ" value="Heart" />Heart</td>
                <td><form:errors path="organ" cssClass="error"/></td>
            </tr>
            
            
     
            <tr>
                <td colspan="3">
                    
                            <input type="submit" value="Register"/>

                </td>
            </tr>
        </table>
    </form:form>
   
</body>