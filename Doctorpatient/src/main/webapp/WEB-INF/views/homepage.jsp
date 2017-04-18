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
	   
	   javascript:window.history.forward(1);
</script>
</head>
<body >
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

	<div><h3 align="center" style="color: red;">${success}</h3></div>
	<div>
		<div class="outer" >
			<table>
				<tr style="padding: 10px">
					<td><form:form action="login" method="post"
							modelAttribute="login">
							<form:input type="text" value="" path="username"
								onfocus="if(this.value  == 'User Id') { this.value = ''; } "
								onblur="if(this.value == '') { this.value = 'User Id'; } " />

							<form:password path="password" />
							<input type="submit" value="Sign In" class="button" />
							<!--  <div style="color: red">${error}</div>-->
						</form:form></td>
				</tr>

				<tr style="padding: 10px">
					<td><a href="" style="text-decoration: none; color: #6495ED;">Forgot
							User Id?</a></td>
				</tr>
				<tr style="padding: 10px">
					<td><a href="" style="text-decoration: none; color: #6495ED;">Forgot
							Password?</a></td>
				</tr>
				<tr style="padding: 10px">
					<td><a  href="#"
						style="text-decoration: none; color: #6495ED;"
						onclick="showRegform('registeruser');">New User ?Register</a></td>
				</tr>
				
				<tr style="padding: 10px">
					<td><a  href="#"
						style="text-decoration: none; color: #6495ED;"
						onclick="showRegform('registerorgandonor');">Register Organ Donor</a></td>
				</tr>
				
				<tr style="padding: 10px">
				
						<td><a href="<c:url value='organsearch?organ=hello'  />"  style="text-decoration: none; color: #6495ED;">ORGANSEARCH</a></td>
				</tr>
				
				
				
			</table>


		</div>
		
		<div id="container"  style="background-color:#90EE90;color:  #fff;width: 80%; height: 500px">
			
			<img alt=""
				src="${pageContext.request.contextPath}/resources/images/hospitalImage.png"
				style="width: auto; height: auto">
		</div>
	</div>
	<div>
		<h1 align="center" style="color: #FF8C00">Who We Are</h1>
		<p align="center">Your homepage should be the first page that
			visitors to your site see, so make sure you give a concise overview
			of who you are, what you do and why you are right for them. This area
			is fully editable and gives you the opportunity to go into more
			detail about your business, what you do and what sets you apart from
			the competition. Your homepage should be the first page that visitors
			to your site see, so make sure you give a concise overview of who you
			are, what you do and why you are right for them. This area is fully
			editable and gives you the opportunity to go into more detail about
			your business, what you do and what sets you apart from the
			competition.</p>
	</div>
	<div>
		<img alt=""
			src="${pageContext.request.contextPath}/resources/images/hosptialdoctorcnt.png">
	</div>
	<div>
		<h1 align="center" style="color: #FF8C00">What We Do</h1>
		<table align="center">
			<tr>
				<td style="padding-right: 15px; width: 30; height: 50"><img
					alt=""
					src="${pageContext.request.contextPath}/resources/images/home1.jpg"></td>
				<td style="padding-right: 15px; width: 30px; height: 50"><img
					alt=""
					src="${pageContext.request.contextPath}/resources/images/home2.jpg"></td>
				<td style="padding-right: 15px; width: 30; height: 50"><img
					alt=""
					src="${pageContext.request.contextPath}/resources/images/hom3.jpg"></td>
			</tr>
			<tr style="background-color: #FFA500; color: white">
				<td style="padding-right: 15px;" align="center"><h2
						align="center">Services</h2>
					<p>This area is fully editable and gives you the opportunity to
						go into more detail about your business, what you do and what sets
						you apart from the competition.</p></td>
				<td style="padding-right: 15px;" align="center"><h2
						align="center">Services</h2>
					<p>This area is fully editable and gives you the opportunity
						to go into more detail about your business, what you do and what
						sets you apart from the competition.</p></td>
				<td style="padding-right: 15px;" align="center"><h2
						align="center">Services</h2>
					<p>This area is fully editable and gives you the opportunity to
						go into more detail about your business, what you do and what sets
						you apart from the competition.</p></td>
			</tr>
		</table>
	</div>
	<br>
	<div style="background-color: #DCDCDC; height: 10%;padding: 10px" >
		<p align="center">All rights reserved&copy; UCMO</p>
		
	</div>


</body>
</html>