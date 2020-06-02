 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示数据信息(原始的el和jstl表达式展示数据)</title>

<script type="text/javascript"
	src="${basePath}/static/bootstrap/js/jquery-1.8.3.js"></script>
<link href="${basePath}/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>


<body>
	<!-- 搭建显示数据页面 -->
	<div class="container" style="border: 1px solid red;">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM框架测试运行练习</h1>
			</div>
		</div>

		<!-- 操作按钮（新增和删除）-->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-success btn-sm">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					新增
				</button>
				<button type="button" class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除
				</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>选择</th>
						<th>ID</th>
						<th>NAME</th>
						<th>AGE</th>
						<th>Gender</th>
						<th>E-mail</th>
						<th>DEPTNO</th>
						<th>操作</th>
					</tr>
					<!-- 遍历获取员工 信息  list首字母一定要小写-->
					<c:forEach items="${pageInfo.list}" var="emp">
						<tr>
							<td><input type="checkbox"></td>
							<td>${emp.id}</td>
							<td>${emp.name}</td>
							<td>${emp.age}</td>
							<td>${emp.gender == "M"?"男":"女"}</td>
							<td>${emp.email}</td>
							<td>${emp.dept.dname}</td>
							<td>
								<button class="btn btn-info  btn-xs">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger  btn-xs">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- 分页条 -->
		<div class="row">
		
			<!-- 分页文字信息 -->
			<div class="col-md-6">
				当前页：${pageInfo.pageNum},总页数：${pageInfo.pages },总信息量：${pageInfo.total}
			</div>
			
			<!-- 分页数字信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="emps?pageNum=1">首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage}">
							<li><a href="emps?pageNum=${pageInfo.pageNum-1}" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
					<!-- 连续显示的页码 -->
					<c:forEach items="${pageInfo.navigatepageNums }" var="pagenum">
						<!-- 判断是否是当前页码，如果是则高亮度显示 -->
						<c:if test="${pagenum == pageInfo.pageNum }">
							<li class="active"><a href="emps?pageNum=${pagenum}">${pagenum}</a></li>
						</c:if>
						<c:if test="${pagenum != pageInfo.pageNum }">
							<li><a href="emps?pageNum=${pagenum}">${pagenum}</a></li>
						</c:if>
					</c:forEach>

					<c:if test="${pageInfo.hasNextPage}">
							<li><a href="emps?pageNum=${pageInfo.pageNum+1}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
						
					<li><a href="emps?pageNum=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
			
		</div>

	</div>

</body>
</html>