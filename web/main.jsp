<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
	<script type="text/javascript" src="static/js/m_ajax.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>账号</td>
				<td>密码</td>
				<td>性别</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>






	<script type="text/javascript">
		//页面加载 默认应该第一页
		$(function() {
			init(1);
		});

		//5//////
		function init(currentPage) {
			$("#tbody").empty();
			var url = "loadUsersListPager";
			var data = {
				currentPage : currentPage
			};
			ajax(url, data, function(result) {
				//list,totalPage,currentPage,pageSize,start,
				var trs="";
				$.each(result.list, function(i, v) {
					//v即为对象，通过属性去访问值
					trs += "<tr>";
					trs += "<td>"+ v.uid +"</td>";
					trs += "<td>"+ v.uname +"</td>";
					trs += "<td>"+ v.account +"</td>";
					trs += "<td>"+ v.pwd +"</td>";
					trs += "<td>"+ v.sex +"</td>";
					trs += "<td><a href='javascript:upd("+ v.uid +")'>详细信息</a><a href='javascript:del("+ v.uid +")'>删除</a></td>";
					trs += "</tr>";
				});
				//6/ 做上一页，需要注意判断是否是首页
				trs+="<tr>";
				trs+="<td colspan='6'>";
				if(result.currentPage==1){
					trs+="<a href='#'>«</a>";
				}else{
					//不是第一页
					trs+="<a href='javascript:pre("+(result.currentPage-1)+")'><h4><<</h4></a>";
				}
				if(result.currentPage==result.totalPage){
					trs+="<a href='#'>»</a>";
				}else{
					trs+="<a href='javascript:nxt("+(result.currentPage+1)+")'>>></a>";
				}
				trs+="</td></tr>";
				$("#tbody").append(trs);
			});
		}
		function del(uid){
			var url="delete";
			var data={
				uid:uid
			};
			ajax(url,data,function(result){
				alert("删除成功");
				if(result !==0){
					window.location.href="main.jsp"
				}
			});
		}
		function pre(i){
			//alert(i);
			init(i);
		}
		function nxt(i){
				init(i);
		}
		function cpg(i){
			init(i);
	}
	</script>
</body>
</html>


