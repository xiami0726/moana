<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="Login.css"/> 
</head>
<body>
	<div id="login">   
		<h1>Login</h1>   
		    <form action="login?action=login" method="post"> 
			  	用户名：<input type="text" name="userName"/><br/>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/>
				<br/>
			     <!-- <a href="login?action=login_input">登录</a> -->
			    <input type="submit" value="登录"/>
			    <a href="register?action=register_input">注册</a> 
		    </form>
    </div>
</body>
</html>