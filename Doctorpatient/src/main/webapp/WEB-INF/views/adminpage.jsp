<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">


.left{
    width:20%;
    height:500px;
    border:1px solid #ccc;
    float: left;
    background-color:#FFF0F5;
    
}

.right{
    width:79.5%;
    height:500px;
    border-left:1px solid #ccc;
    float: right;
    
    }
    
    .logout{
    
    height:140px;
    
    
    }
    
    

</style>

<script type="text/javascript">

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
<body>
<div  style=" background-color:#F0F8FF;color:  purple; width: 85%;float: left;font-family: sans-serif;">
 <h1 align="center">Hello Admin,<%=session.getAttribute("uname") %> !!</h1>
 <h1 align="center">Welcome !!</h1>
 
 </div>
 
 <div class="logout" style=" background-color:#F0F8FF; width: 15%;float: right; font-family: sans-serif;">
 <a href="logout" >
			<button >
				<img src="${pageContext.request.contextPath}/resources/images/Logout.jpg" alt="Logout" onMouseOver="Logout" 
					title="<%=session.getAttribute("uname")%>  Signout " height="70" width="90" style="float: right">
			</button>
</a>
</div>
<hr>

			<h3 align="center" style="color:  #CD5C5C">${success}</h3>

		<div class="left" >
		
			<br>
			<br>
			 

			<table>
				<tr style="padding: 5px">
					<td><a href="#" 
						onclick="showRegform('adddoctor');">Add Doctor</a></td>
				</tr>

				<tr style="padding: 5px">
					<td><a href="#" 
						onclick="showRegform('availabilitydoc');">View Doctor List</a></td>
				</tr>
			</table>
		</div>
		<div class="right" id="container" style="margin:0;background-color:  #90EE90;color: #fff" ></div>
	
			<div style="background-color: #DCDCDC; height: 10%">
		<br>
		<br>
		
		</div>
</body>
</html>