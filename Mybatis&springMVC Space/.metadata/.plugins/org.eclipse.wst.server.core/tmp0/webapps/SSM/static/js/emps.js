
//定义全局变量保存总记录数
var total;

//1.页面加载完成以后，直接发送ajax请求，拿到页面数据
	$(function() {
		alert("进入首页加载数据");
		 to_page(1);
	});
	

	/**
	 * ajax 加载数据分页数据
	 */
	function to_page(pageNum){
		alert("进入首页加载数据");
		$.ajax({
			url : "http://localhost:8080/SSM/empsJson",
			data : "pageNum="+pageNum,
			type : "get",
			success : function(result) {
				alert("进入ajax请求数据");
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
			var id = "<td>"+item.id+"</td>";
			var name ="<td>"+item.name+"</td>";
			var age = "<td>"+item.age+"</td>";
			var email = "<td>"+item.email+"</td>";
			var gender = $("<td></td>").append(item.gender == "M"?"男":"女");
			var deptName = "<td>"+item.dept.dname+"</td>";
			//构建操作按钮
			var edit = $("<button></button>").addClass("btn btn-info  btn-xs")
					          .append($("<span></span>").addClass(
							"glyphicon glyphicon-pencil")).append("编辑");
			
			var delBtn = $("<button></button>")
					     .addClass("btn btn-danger  btn-xs")
					     .append($("<span></span>")
					     .addClass("glyphicon glyphicon-remove"))
					     .append("删除");
			//将上面两个按钮放到一个td中
			var operating = $("<td></td>").append(edit).append(" ").append(delBtn);
		
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
	
	
	/**
	 * 构建分页信息数据
	 */
	function build_page_info(result) {
		$("#page_info").empty();//清空数据
		var pageInfo = result.result.pageInfo;
		$("#page_info").append("当前页："+pageInfo.pageNum+",总页数："+pageInfo.pages+",总信息量："+pageInfo.total);
		total=pageInfo.total;//给全局变量赋值，用于新增员工的单击事件
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
		var firstPageli = $("<li></li>").append("<a href='javascript:void(0);'>首页</a>");
	    var lastPageLi =  $("<li></li>").append("<a href='javascript:void(0);'>末页</a>");
	   if (!pageInfo.isFirstPage) { //判断当前是否是第一页
		   firstPageli.click(function(){
		    	to_page(1);
		    });
	    }
	   
	    if (!pageInfo.isLastPage) {//判断当前是否是末页
	    	 lastPageLi.click(function(){
	 	    	to_page(pageInfo.pages);
	 	    });
		}
	   
	    
	    //前一页和后一页
	    var beforePage = $("<li></li>").append('<a href="javascript:void(0);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>');
		var nextPage =$("<li></li>").append('<a href="javascript:void(0);" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>');
	    //处理上一页和下一页效果 ,并绑定单击事件
		if (pageInfo.hasPreviousPage == false) {
			beforePage.addClass("disabled");
		}else {
			beforePage.click(function(){
				to_page(pageInfo.pageNum-1);
			});
		}
		if (pageInfo.hasNextPage == false) {
			nextPage.addClass("disabled");
		}else {
			nextPage.click(function(){
				to_page(pageInfo.pageNum+1);
			});
		}
		
		//给ul添加首页和前一页
		ul.append(firstPageli).append(beforePage);
		//加载连续显示的页码
		$.each(pageInfo.navigatepageNums, function(index, item){
			var numLi = $("<li></li>").append("<a href='javascript:void(0);'>"+item+"</a>");
			//如果是当前页，则突出显示
			if (pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			//绑定单击事件
			numLi.click(function(){
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
	
