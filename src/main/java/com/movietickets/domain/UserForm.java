package com.movietickets.domain;

import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private int userId;
	private String userName;
	private String password;
	private String repassword;
	private String email;
	
	Map<String, String> msg = new HashMap<>();
	
	public boolean validate(){
		if ("".equals(userName)){
			msg.put("userName", "用户名不能为空！");
		} else if (!userName.matches("\\w{3,8}")){ 	//用户名：必须输入，且3~8字母组成
			msg.put("userName", "用户名由3~8字母组成");
		}
		
		if ("".equals(password)){
			msg.put("password", "密码不能为空！");
		} else if (!password.matches("\\d{3,8}")){ 	//密码：必须输入，且3~8数字组成
			msg.put("password", "密码由3~8数字组成");
		}
		
		
		//确认密码
		if (!repassword.equals(password)){
			msg.put("repassword", "前后密码输入不一次");
		}
		
		//邮箱
		if ("".equals(email)){
			msg.put("email", "邮箱不能为空！");
		} else if (!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){ 	//密码：必须输入，且3~8数字组成
			msg.put("email", "邮箱格式不符合实际规范");
		}
		
		return msg.isEmpty();//map集合没有数据时，返回true
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	
	
}
