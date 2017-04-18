<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>


<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
 <style type="text/css">



div #container {
	
	overflow: hidden;
}

.outer {
	width: 17%;
	height: 500 px; 
	color: navy;
	background-color: pink;
	border: 2px solid darkblue;
	padding: 5px;
	float: left;
}


 .error {
        color: #ff0000;
    }
    
    .left{
    width:20%;
    height:200px;
    border:1px solid #ccc;
    float: left;
    background-color:#FFF0F5;
    
}

</style>

<script type="text/javascript">
/*	function go(obj) {
		var page = obj.href;
		document.getElementById('container').innerHTML = '<object data="'+page+
      '" type="text/html"><embed src="'+page+'" type="text/html"  /></object>';
		return false;
	}*/
	

	
	
	function GetXmlHttpObjectWithOutHandler() {
	       var objXmlHttp = null;
	       if (navigator.userAgent.indexOf("MSIE") >= 0) {
	           var strName = "Msxml2.XMLHTTP";
	           if (navigator.appVersion.indexOf("MSIE 5.5") >= 0) {
	               strName = "Microsoft.XMLHTTP";
	           }
	           try {
	               objXmlHttp = new ActiveXObject(strName);
	               return objXmlHttp;
	           } catch (e) {
	               //showWSalert("Error. Scripting for ActiveX might be disabled");
	               return;
	           }
	       }

	       if (navigator.userAgent.indexOf("Mozilla") >= 0) {
	           objXmlHttp = new XMLHttpRequest();
	           return objXmlHttp;
	       }
	   }
	   
	   function showRegform(url) {
	       var currObj = this;
	       this.pxmlContentLoaderHttp = GetXmlHttpObjectWithOutHandler();
	       this.loadAreaContentStatusChanged = function () {
	           if (currObj.pxmlContentLoaderHttp.readyState == 4 || currObj.pxmlContentLoaderHttp.readyState == "complete") {
	        	   console.log("Entered into "+currObj.pxmlContentLoaderHttp.responseText);
	               document.getElementById("container").innerHTML = currObj.pxmlContentLoaderHttp.responseText;
	           }
	       }
	       this.pxmlContentLoaderHttp.onreadystatechange = function () {
	           currObj.loadAreaContentStatusChanged();
	       };
	       this.pxmlContentLoaderHttp.open("POST", url, true);
	       this.pxmlContentLoaderHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	       this.pxmlContentLoaderHttp.send("");
	   }
	   
	   
</script>
</head>
<body style="background-color:#90EE90;">
	<div style="width: 100%;background-color:#F0F8FF; padding: 10px" >


		<table>
			<tr>
				<td style="padding-right: 60px; padding-left: 100px"><img
					alt="Universal"
					src="${pageContext.request.contextPath}/resources/images/name.png"></td>
				<td><a href="home" 
					style=" padding-right: 40px;"
					><font
						style="font-size: 30px;">Home</font> </a></td>
				<td><a href="#"
					style=" padding-right: 40px;"
					onclick="showRegform('about')"><font
						style="font-size: 30px; ">About Us </font></a></td>
				<td><a href="#"
					style="padding-right: 40px;"
					onclick="showRegform('services')"><font
						style="font-size: 30px; ">Services</font></a></td>
				<td><a href="#"
					style=" padding-right: 40px;"
					onclick="showRegform('contact')"><font
						style="font-size: 30px; c">Contact </font></a></td>
			</tr>
		</table>
	</div>
		
		<h2 style="color:red;font-family: sans-serif; " align="center">ORGAN SEARCH</h2>
		<div id="container"  style="width: 80%; height: 500px">
		
		<table style="position: absolute;left: 250px;top: 150px">
			
				<tr style="padding: 10px">
					<td><form action="organsearch" method="get">
							<input type="text" value="" name="organ"/>

							<input type="submit" value="SEARCH" class="button" />
							
						</form></td>
				</tr>
			</table>
		  <c:if test="${not empty organdetails}">

		
		<table border="1" style="border-color: navy; position: absolute;left: 250px;top: 200px">
		<thead>
		<tr style="color: purple">
				<th>ORGAN DONOR</th>
				<th>SEX</th>
				<th>MOBILE</th>
				<th>E-MAIL</th>
				<th>BLOOD GROUP</th>
				
		</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${organdetails}" varStatus="status">
				 <tr>
      				 <td><c:out value="${listValue.oname}" /></td>
       				<td><c:out value="${listValue.sex}" /></td>
      				 <td><c:out value="${listValue.mobile}" /></td>
       				<td><c:out value="${listValue.email}" /></td>
       				<td><c:out value="${listValue.organ}" /></td>
       				<td><c:out value="${listValue.bloodgroup}" /></td>
       				
       				
     			</tr>
			</c:forEach>
			 </tbody>
		</table>

	</c:if>

		  
		
		</div>
			
		

</body>
</html>