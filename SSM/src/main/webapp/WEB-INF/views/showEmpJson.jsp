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
<title>展示数据信息(使用json)</title>

<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript" src="http://localhost:8080/SSM/static/js/emps.js"></script> -->
<%-- <script type="text/javascript" src="${basePath}/static/js/emps.js"></script> --%>
<script type="text/javascript">

</script>
<style type="text/css"></style>
</head>


<body>

	<!-- 新增 模态框 -->
	<div class="modal fade" id="empAddModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增员工</h4>
				</div>
				<div class="modal-body">
					<!--********************** 新增表单*************** -->
					<form class="form-horizontal">
						<div class="form-group">
							<label for="Name" class="col-sm-2 control-label">NAME：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="Name" name="name"
									placeholder="姓名" onblur="checkName()">
							</div>
						</div>
						<div class="form-group">
							<label for="age" class="col-sm-2 control-label">AGE：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="age" id="age"
									placeholder="年龄">
							</div>
						</div>

						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">GENDER：</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="inlineRadio1" value="M" checked="checked">
									男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="inlineRadio2" value="F"> 女
								</label>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">E-mail</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control" id="email"
									placeholder="email@guigu.com">
							</div>
						</div>

						<div class="form-group">
							<label for="DeptName" class="col-sm-2 control-label">DeptName</label>
							<div class="col-sm-3">
								<select class="form-control" name="deptNo" id="selectDepts">
								</select>
							</div>
						</div>
					</form>
					<!-- ************ 表单结束处 ***************  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save_emp">保存</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 修改 模态框 -->
	<div class="modal fade" id="empUpdateModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改员工信息</h4>
				</div>
				<div class="modal-body">
					<!--********************** 修改表单*************** -->
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="updateName" name="name">测试</p>
							</div>
						</div>
						<div class="form-group">
							<label for="age" class="col-sm-2 control-label">AGE：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="age"
									id="updateAge" placeholder="年龄">
							</div>
						</div>

						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">GENDER：</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="updateInlineRadio1" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="updateInlineRadio2" value="F"> 女
								</label>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">E-mail</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control"
									id="updateEmail" placeholder="email@guigu.com">
							</div>
						</div>

						<div class="form-group">
							<label for="DeptName" class="col-sm-2 control-label">DeptName</label>
							<div class="col-sm-3">
								<select class="form-control" name="deptNo" id="updateDepts">
								</select>
							</div>
						</div>
					</form>
					<!-- ************ 表单结束处 ***************  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_emp">更新</button>
				</div>
			</div>
		</div>
	</div>



	<!-- 搭建显示数据页面 -->
	<div class="container" style="border: 1px solid red;">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM框架运行测试</h1>
			</div>
		</div>

		<!-- 操作按钮（新增和删除）-->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-success btn-sm" id="addEmp_btn">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					新增
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					id="deleteEmp_btn">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除
				</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>选择</th>
							<th>ID</th>
							<th>NAME</th>
							<th>AGE</th>
							<th>GENDER</th>
							<th>E-mail</th>
							<th>DEPTNO</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 分页条 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info"></div>
			<!-- 分页数字信息 -->
			<div class="col-md-6" id="page_nav"></div>
		</div>

	</div>


</body>
<script type="text/javascript">
	//定义全局变量保存总记录数
	var total;
	var bool = false;
	var updateEmpId;

	//1.页面加载完成以后，直接发送ajax请求，拿到页面数据
	$(function() {
		to_page(1);
	});

	/**
	 * ajax 加载数据分页数据
	 */
	function to_page(pageNum) {
		$.ajax({
			url : "${basePath}/EMP/empsJson",
			data : "pageNum=" + pageNum,
			type : "get",
			success : function(result) {
				//console.log(result);//控制台打印数据  
				//1.解析并构建员工信息
				build_emps_table(result);
				//2.解析并构建分页信息数据
				build_page_info(result);
				//3.解析并构建分页条数据
				build_page_nav(result);
			}
		});
	}

	/**
	 * 构建table数据
	 * @param result
	 */
	function build_emps_table(result) {
		//每次加载数据前清空数据
		$("#emps_table tbody").empty();
		//第一个result是参数，第二个result是毁掉函数中返回的result结果集
		var emplist = result.result.pageInfo.list;

		$.each(emplist, function(index, item) {

			var select = $("<td></td>").html('<input type="checkbox">');
			var id = "<td>" + item.id + "</td>";
			var name = "<td>" + item.name + "</td>";
			var age = "<td>" + item.age + "</td>";
			var email = "<td>" + item.email + "</td>";
			var gender = $("<td></td>").append(item.gender == "M" ? "男" : "女");
			var deptName = "<td>" + item.dept.dname + "</td>";
			
			//构建操作按钮
			var edit = $("<button></button>").addClass(
					"btn btn-info  btn-xs editBtn").append(
					$("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("编辑");
			//给编辑按钮添加单击事件
			edit.click(function(){
				//加载下拉列表框
				getDeptInfo("#updateDepts")
				//加载需要编辑的员工信息
				editEmp(item.id);
				//打开弹框
				$("#empUpdateModel").modal({
					backdrop : "static"
				});
			});
			
			//构建删除按钮
			var delBtn = $("<button></button>").addClass(
					"btn btn-danger  btn-xs deleteBtn").append(
					$("<span></span>").addClass("glyphicon glyphicon-remove"))
					.append("删除");
			
			
			//将上面两个按钮放到一个td中
			var operating = $("<td></td>").append(edit).append(" ").append(
					delBtn);

			$("<tr></tr>").append(select)
			              .append(id)
			              .append(name)
			              .append(age)
					      .append(gender)
					      .append(email)
					      .append(deptName)
					      .append(operating)
					      .appendTo("#emps_table tbody");

		});
	}

	/* 获取编辑员工信息 */
	function editEmp(id){
		updateEmpId=id;
		$.ajax({
			url:"${basePath}/EMP/queryEmp",
			type: "get",
			data: "id="+id,
			success : function(result) {
				var emp = result.result.emp;
				$("#updateName").text(emp.name);
				$("#updateAge").val(emp.age);
				$("#updateEmail").val(emp.email);
				$("#empUpdateModel input[name=gender]").val([emp.gender]);
				$("#empUpdateModel select").val([emp.deptNo]);
			}
		});
	}
	
	
	
	/**
	 * 构建分页信息数据
	 */
	function build_page_info(result) {
		$("#page_info").empty();//清空数据
		var pageInfo = result.result.pageInfo;
		$("#page_info").append(
				"当前页：" + pageInfo.pageNum + ",总页数：" + pageInfo.pages + ",总信息量："
						+ pageInfo.total);
		total = pageInfo.total;//给全局变量赋值，用于新增员工的单击事件
	}

	/**
	 * 构建分页条数据
	 */
	function build_page_nav(result) {
		$("#page_nav").empty();//清空数据
		var pageInfo = result.result.pageInfo;//获取分页数据
		//构建ul父元素
		var ul = $("<ul></ul>").addClass("pagination");
		//分别构建首页和末页超链接，并绑定单击事件
		var firstPageli = $("<li></li>").append(
				"<a href='javascript:void(0);'>首页</a>");
		var lastPageLi = $("<li></li>").append(
				"<a href='javascript:void(0);'>末页</a>");
		if (!pageInfo.isFirstPage) { //判断当前是否是第一页
			firstPageli.click(function() {
				to_page(1);
			});
		}

		if (!pageInfo.isLastPage) {//判断当前是否是末页
			lastPageLi.click(function() {
				to_page(pageInfo.pages);
			});
		}

		//前一页和后一页
		var beforePage = $("<li></li>")
				.append(
						'<a href="javascript:void(0);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>');
		var nextPage = $("<li></li>")
				.append(
						'<a href="javascript:void(0);" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>');
		//处理上一页和下一页效果 ,并绑定单击事件
		if (pageInfo.hasPreviousPage == false) {
			beforePage.addClass("disabled");
		} else {
			beforePage.click(function() {
				to_page(pageInfo.pageNum - 1);
			});
		}
		if (pageInfo.hasNextPage == false) {
			nextPage.addClass("disabled");
		} else {
			nextPage.click(function() {
				to_page(pageInfo.pageNum + 1);
			});
		}

		//给ul添加首页和前一页
		ul.append(firstPageli).append(beforePage);
		//加载连续显示的页码
		$.each(pageInfo.navigatepageNums, function(index, item) {
			var numLi = $("<li></li>").append(
					"<a href='javascript:void(0);'>" + item + "</a>");
			//如果是当前页，则突出显示
			if (pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			//绑定单击事件
			numLi.click(function() {
				to_page(item);
			});
			ul.append(numLi);//添加连续显示的页码
		});

		//添加后一页和末页
		ul.append(nextPage).append(lastPageLi);

		//将ul放到nav中
		var nav = $("<nav></nav>");
		nav.append(ul);
		//将整个分页条 nav 放入div中
		$("#page_nav").append(nav);
	}

	/**
	 * 新增模态框
	 */
	$("#addEmp_btn").click(function() {
		//每次打开模态框，重置内部内容
		$("#empAddModel form")[0].reset();
		//加载部门信息,到新增下拉列表中
		getDeptInfo("#selectDepts");
		//设定单击模态框外面部分，不退出模态框
		$("#empAddModel").modal({
			backdrop : "static"
		});
	});

	/* 加载部门信息  参数是需要加载信息的下拉列表框的ID */
	function getDeptInfo(documentId) {
		        //加载部门信息前清空部门信息
		        $(documentId).empty();
				$.ajax({
					url : "${basePath}/DEPT/queryDept",
					type : "get",
					success : function(result) {
						var deptList = result.result.deptList;
						$(documentId)
								.append(
										'<option value="0" selected="selected" >--请选择--</option>');
						$.each(deptList, function(index, depts) {
							var select = "<option value='"+depts.id+"'>"
									+ depts.dname + "</option>";
							$(documentId).append(select);
						});
					}
				});
	}

	/* 单击保存按钮 新增员工 */
	$("#save_emp").click(function() {

		//保存前首先进行数据验证
		if (!checkform("#Name","#age","#email","#selectDepts") || !bool) {
			return false;
		}

		//$("#empAddModel form").serialize()的作用是将表单中的数据取出来，
		//序列化表格中的内容问字符串，用于ajax请求，效果如同Struts2中的属性对象的自动封装，而不需要在获取属性值封装到对象中
		$.ajax({
			url : "${basePath}/EMP/saveEmp",
			type : "post",
			data : $("#empAddModel form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					alert("新增成功！！！");
					//操作成功后,关闭模态框，并跳转到最后一页，显示新增后的信息
					$("#empAddModel").modal("hide");
					//当传入的当前页码数大于最大页码数时，PageHelper插件总是显示最后一页，故将总数据条数当做参数放入其中
					to_page(total);
				} else if (result.code == 200) {
					alert("新增失败！！！");
				}
			}
		});
	});

	/* 验证表单输入数据 */
	function checkform(name,age,email,selectDepts) {

		var name = $(name).val().trim();
		if (name == "" || name == null) {
			alert("员工姓名不能为空！");
			return false;
		} else if (name.length >= 5) {
			alert("员工姓名长度不得大于4个字符！");
			return false;
		}

		var age = $(age).val().trim();
		var regAge = /^[0-9]*$/;
		if (age == "" || age == null) {
			alert("年龄不能为空！");
			return false;
		} else if (regAge.test(age) == false) {
			alert("格式不正确，年龄必须是数字！");
			return false;
		} else if (age < 18 || age > 60) {
			alert("员工年龄必须在18~60岁之间！");
			return false;
		}

		var email = $(email).val().trim();
		/* 合法E-mail地址：     
		1. 必须包含一个并且只有一个符号“@”     
		2. 第一个字符不得是“@”或者“.”     
		3. 不允许出现“@.”或者.@     
		4. 结尾不得是字符“@”或者“.”     
		5. 允许“@”前的字符中出现“＋”     
		6. 不允许“＋”在最前面，或者“＋@” */
		var regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (email != "" && email != null) {
			if (regEmail.test(email) == false) {
				alert("您输入的邮箱有误,请重新核对后再输入!");
				$("#email").focus();
				return false;
			}
		}

		var deptName = $(selectDepts).val().trim();
		if (deptName == 0) {
			alert("请选择部门名称！");
			return false;
		}

		return true;
	}

	/* 验证用户名是否存在 */
	function checkName() {
		var name = $("#Name").val().trim();
		if (name != "" || name != null) {
			$.ajax({
				url : "${basePath}/EMP/queryEmpCount",
				type : "get",
				data : "name=" + name,
				success : function(result) {
					if (result.code == 200) {
						alert("对不起，该名称已经存在！");
						bool = false;
						return false;
					} else if (result.code == 100) {
						bool = true;
						return true;
					}
				}
			});
		}
	}

	/* 更新员工信息 */
	$("#update_emp").click(function(){
		
		//验证年龄
		var age = $("#updateAge").val().trim();
		var regAge = /^[0-9]*$/;
		if (age == "" || age == null) {
			alert("年龄不能为空！");
			return false;
		} else if (regAge.test(age) == false) {
			alert("格式不正确，年龄必须是数字！");
			return false;
		} else if (age < 18 || age > 60) {
			alert("员工年龄必须在18~60岁之间！");
			return false;
		}
		
		
		//验证邮箱
		var email = $("#updateEmail").val().trim();
		/* 合法E-mail地址：     
		1. 必须包含一个并且只有一个符号“@”     
		2. 第一个字符不得是“@”或者“.”     
		3. 不允许出现“@.”或者.@     
		4. 结尾不得是字符“@”或者“.”     
		5. 允许“@”前的字符中出现“＋”     
		6. 不允许“＋”在最前面，或者“＋@” */
		var regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (email != "" && email != null) {
			if (regEmail.test(email) == false) {
				alert("您输入的邮箱有误,请重新核对后再输入!");
				$("#email").focus();
				return false;
			}
		}
		
		//验证部门
		var deptName = $("#updateDepts").val().trim();
		if (deptName == 0) {
			alert("请选择部门名称！");
			return false;
		}
		
	});
	
	
</script>

</html>
