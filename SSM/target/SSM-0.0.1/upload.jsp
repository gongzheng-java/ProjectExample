<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static/bootstrap/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
<title>文件上传测试页面</title>
</head>
<body>
	<form id="myform" method="post">
		附件： <input id="aa" type="file" name="record" /> <input type="button"
			onclick="doUpload()" value="提交" />
	</form>

	<div>
		<h3>不通过表单上传文件</h3>

		附件:<input id="file" type="file" name="file" />
		<button id="upload">上传</button>

	</div>
</body>
</div>
<script type="text/javascript">
$("#upload").click(function(){
	if(document.getElementById("file").value == null || document.getElementById("file").value == ""){
        alert("请选择上传文件");
        return
}
	var formData = new FormData();
	formData.append('file', $('#file')[0].files[0]);  

	$.ajax({
		url: "upload/fileupload",
		type: "POST",
		data: formData,
		/**
		*必须false才会自动加上正确的Content-Type
		*/
		contentType: false,
		/**
		* 必须false才会避开jQuery对 formdata 的默认处理
		* XMLHttpRequest会对 formdata 进行正确的处理
		*/
		processData: false,
		async: false,  
        cache: false,  
        
		success: function (data) {
			alert("success");

		},
		error: function (data) {
			alert("上传失败！");

		}
	});	
})		


function doUpload() { 

	if(document.getElementById("aa").value == null || document.getElementById("aa").value == ""){
	        alert("请选择上传文件");
	        return
	}
    var formData = new FormData($( "#myform" )[0]);  
    $.ajax({  
         url: 'upload/fileupload' ,  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("上传成功！！！");  
         },  
         error: function (returndata) {  
             alert("上传失败");  
         }  
    });  
}
</script>
</html>