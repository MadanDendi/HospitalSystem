<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<style type="text/css">
.button {
	background-color: #6495ED; /* Light Blue */
	border: none;
	color: white;
	padding: 8px 14px;
	text-align: center;
	text-decoration: none;
	display: compact;
	font-size: 16px;
}

.navbar-collapse {
	z-index: 9999;
}

.row {
	white-space: nowrap;
}

.hold {
	display: inline;
	margin: 0px;
	padding: 0px;
}

#content {
	display: block;
	margin: 0px;
	padding: 0px;
	position: relative;
	top: 90px;
	height: auto;
	max-width: auto;
	overflow-y: hidden;
	overflow-x: auto;
	white-space: nowrap;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body bgcolor="#F5F5DC">
	<div style="width: 100%;">
		<div
			style="float: left; width: 20%; color: #4B0082; font-style: italic;"
			class="navbar-collapse">
			<input type="image" src="${pageContext.request.contextPath}/resources/images/HospitalIcon.png" alt="Hospital"
				width="140" height="50">
		</div>
		<div
			style="float: left; width: 40%; color: #4B0082; font-style: italic; text-align: center;"
			class="navbar-collapse">
			<a href=""> <input type="button" value="About Us" class="button"
				style="width: 140; height: 50">
			</a> &nbsp;&nbsp; <a href=""> <input type="button"
				value="International Patients" class="button"
				style="width: 200; height: 50">
			</a>
		</div>
		<div style="float: right;">


		<form:form action="login" method="post" modelAttribute="login" >
				<form:input type="text" value="" path="username"
					onfocus="if(this.value  == 'User Id') { this.value = ''; } "
					onblur="if(this.value == '') { this.value = 'User Id'; } " />
					
					<form:password path="password"/> 
					<input
					type="submit" value="Sign In" class="button" />
					 <!--  <div style="color: red">${error}</div>-->
			</form:form>
			
			
			
			<a href="" style="text-decoration: underline; color: #6495ED;">Forgot
				User Id?</a> &nbsp;&nbsp; <a href="patientregister?new=new"
				style="text-decoration: underline; color: #6495ED;">Forgot
				Password?</a> <br> <a href="registeruser"
				style="text-decoration: underline; color: #6495ED;">New User
				?Register</a>



		</div>
	</div>
	<div style="clear: both"></div>

	<marquee behavior="scroll" direction="left" scrolldelay="1">

		<div
			style="margin-top: 10%; margin-left: 25%; margin-right: 25%; margin-bottom: 10%; background-color: white;">
			<br>
			<h1>Take control of your health today!</h1>
			<h2>
				Ask Universal Personal Health Record helps you receive, <br>
				store and access all your health information online.
			</h2>
			<img alt="" src="${pageContext.request.contextPath}/resources/images/appolo.png">
		</div>

	</marquee>
	<div id="content" class="hold">

		<img src="${pageContext.request.contextPath}/resources/images/2a.png" width="120" height="120" /><br>
		<span>Oncology</span> <img src="${pageContext.request.contextPath}/resources/images/3a.png" width="120"
			height="120" /><br>
		<span>Orthopedics</span> <img src="${pageContext.request.contextPath}/resources/images/4a.png" width="120"
			height="120" /><br>
		<span>Neurology</span>

	</div>
</body>
</html>