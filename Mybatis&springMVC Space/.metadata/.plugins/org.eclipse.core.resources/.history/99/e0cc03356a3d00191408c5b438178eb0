<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<a href="User/findUserList">查看所有User信息</a>
<%-- <jsp:forward page="User/test"></jsp:forward> --%>

<!-- 文件上传 -->
<form name="serForm" action="SpringMVC006/fileUpload" method="post"  enctype="multipart/form-data">
<h1>采用流的方式上传文件</h1>
<input class="up" type="file" name="file" id="up">
<input type="submit" value="上传"/>
</form>
 
<form name="Form2" action="SpringMVC006/fileUpload2" method="post"  enctype="multipart/form-data">
<h1>采用multipart提供的file.transfer方法上传文件</h1>
<input type="file" name="file">
<input class="up" type="submit" value="upload"/>
</form>
 
<form name="Form2" action="SpringMVC006/springUpload" method="post"  enctype="multipart/form-data">
<h1>使用spring mvc提供的类的方法上传文件</h1>
<input type="file" name="file">
<input class="up" type="submit" value="上传"/>

</form>
<br>
<input value="123" id="ceshi">
<button id="np" onclick="btn()">测试</button>
</body>

<script type="text/javascript">

   function btn(){
	   alert(13132);
	   var element = $("#ceshi").val();
	  alert(element);

	   if(document.getElementById("up").value == null || document.getElementById("up").value == ""){
	           alert("请选择上传文件");
	   }
	  
   }


</script>
</html>