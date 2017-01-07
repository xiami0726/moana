package com.movietickets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movietickets.domain.UserForm;
import com.movietickets.service.UserLoginService;
import com.movietickets.service.UserRegisterService;
import com.movietickets.service.impl.UserLoginServiceImpl;
import com.movietickets.service.impl.UserRegisterServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String action = request.getParameter("action");  
		boolean register = false;
		
		System.out.println("action == " + action + "login".equals(action));
		if("login".equals(action)){
			try{
			    String userName = request.getParameter("userName");  
			    String password = request.getParameter("password");
			    String email = request.getParameter("userName"); 
			    
			    UserLoginService urs  = new UserLoginServiceImpl();
			    register = urs.login(userName, password, email);
			    
			    //创建Cookie，将用户名存到叫userName的cookie中
			    Cookie cookie = new Cookie("userName", userName);
			    //将cookie发给浏览器
			    response.addCookie(cookie);
//			    System.out.println(register);
//				System.out.println("login userName->" + userName + ",password->" + password + "email->" + email);
			} catch(Exception e){
				e.printStackTrace();
			} 
			//分发转向
			
			  if (register == true){
			    	System.out.println("登录成功");
					response.getWriter().write("注册成功,1秒后调到主页");
					response.setHeader("refresh", "1；url="+request.getContextPath()+"/buyTicket.jsp");
			    } else {
			    	System.out.println("用户名或密码错误");
			    	response.setHeader("refresh", "1；url="+request.getContextPath()+"/index.jsp");
			    }

        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
