<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<script type="text/javascript" src="static/js/m_ajax.js"></script>
<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<body>
<pre>
<form  method="post">
	username:<input type="text" name="account" id="account">
	password:<input type="password" name="pwd" id="pwd">
	<input type="button" value="login" onclick="login()">
</form>
</pre>
<a href="saveUsers.jsp">注册</a>

<script type="text/javascript">
	function login(){
		var account=$("#account").val();
		var pwd=$("#pwd").val();
		
		var url="login";
		
		var data={
			account:account,
			pwd:pwd
		};

		ajax(url,data,function(result){
			alert(result);
			if(result != 0){
				window.location.href="main.jsp"
			}
		});
	}
</script>
</body>
</html>


