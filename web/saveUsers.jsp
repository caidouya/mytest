<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<!-- 将通用的jsp的内容写在同一个jsp界面中然后引入 -->
<!-- 静态包含是将目标common.jsp界面的内容拿过里和当前界面的jsp代码一起编译后执行 -->
	<script type="text/javascript" src="static/js/m_ajax.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<!-- 动态包含是指目标界面会编译成字节码文件后执行的结果放在这个位置 -->
<%-- <jsp:include page=""></jsp:include> --%>
</head>
<body>
	<pre>
<form  method="post">
	username:<input type="text" name="uname" id="uname">
	account:<input type="text" name="account" id="account">
	password:<input type="password" name="pwd" id="pwd">
	sex:<input type="password" name="sex" id="sex">
	<input type="button" value="save" onclick="saveUsers()">
</form>
</pre>
<script type="text/javascript">
	function saveUsers(){
		
		var uname=$("#uname").val();
		var account=$("#account").val();
		var pwd=$("#pwd").val();
		var sex=$("#sex").val();
		
		var url="save";
		var data={
			uname:uname,
			account:account,
			pwd:pwd,
			sex:sex
		};
		
		ajax(url,data,function(result){
			alert(result);
			if(result!=0){
				window.location.href="index.jsp";
			}else{
				alert("注册失败！");
			}
		});
	}

</script>
</body>
</html>






