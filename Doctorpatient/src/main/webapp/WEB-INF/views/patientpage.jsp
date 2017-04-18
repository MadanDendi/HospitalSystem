<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

legend.green-color a:hover{
    text-decoration: none;
}


 .outer {
    width: 17%;
    height:50%
    color: navy;
    background-color: pink;
    border: 2px solid darkblue;
    padding: 5px;
 }
 
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

.left{
    width:20%;
    height:500px;
    border:1px solid #ccc;
    float: left;
    background-color:#FFF0F5;
    
}

.right{
    width:75%;
    height:500px;
    border-left:1px solid #ccc;
    
    }

</style>
<script type="text/javascript">
/*function go(obj) {
    var page=obj.href;
    document.getElementById('container').innerHTML='<object data="'+page+
      '" type="text/html"><embed src="'+page+'" type="text/html" /></object>';
    return false;
}
*/


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
<body style="background-color: #90EE90">


<div  style=" background-color:#53324d;color:  #fff; width: 85%;float: left">
 <h1 align="center"> Welcome <%=session.getAttribute("uname")  %> !! !!</h1>
 </div>
 <div  style=" background-color:#F0F8FF; width: 15%;float: right">
 <a href="logout" >
			<button >
				<img src="${pageContext.request.contextPath}/resources/images/Logout.jpg" alt="Logout" onMouseOver="Logout" 
					title="<%=session.getAttribute("uname")%>  Signout " height="70" width="90" style="float: right">
			</button>
</a>
</div>

<div>
<div  class="left">
<table>
<tr style="padding: 10px"><td>	
		
			
<a href="#" style="text-decoration: none; color: #6495ED;" onclick="showRegform('availabledoclots');" >VIEW  SLOTS</a>   
</td></tr>
</table>
</div>

<div class="right" id="container" >


</div>
</div>

	
	
</body>
</html>