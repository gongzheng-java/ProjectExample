<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试显示user信息</title>
</head>
<body>
	<div>
		<h2>User信息如下：</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>生日</td>
				<td>性别</td>
				<td>地址</td>
			</tr>
<c:forEach items="${uList}" var="Users">
<tr>
				<td>${Users.id}</td>
				<td>${Users.userName}</td>
				<td>${Users.birthday}</td>
				<td>${Users.sex}</td>
				<td>${Users.address}</td>
			</tr>
</c:forEach>
			
		</table>
	</div>
</body>
</html>