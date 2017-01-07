package com.movietickets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movietickets.domain.UserForm;
import com.movietickets.service.UserRegisterService;
import com.movietickets.service.impl.UserRegisterServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
        if("register_input".equals(action)) {  
			request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if("register".equals(action)){
        	
        	
			try{
				//获取表单数据
	            String userName = request.getParameter("userName");  
	            String password = request.getParameter("password");  
	            String repassword = request.getParameter("repassword");
	            String email = request.getParameter("email");
	            
	            //验证合法用户
			    UserForm uf = new UserForm();
			    uf.setEmail(email);
			    uf.setPassword(password);
			    uf.setRepassword(repassword);
			    uf.setUserName(userName);
			    
			    if (!uf.validate()){//如果map中不为空，说明有错误信息
			    	request.setAttribute("uf", uf);
			    	request.getRequestDispatcher("/register?action=register_input").forward(request, response);
			    	return ;
			    }
			    
	          //调用业务逻辑
	            UserRegisterService urs  = new UserRegisterServiceImpl();
	            register = urs.register(userName, password, email);
	            
				System.out.println("userName->" + userName + ",password->" + password + "email->" + email);
			} catch(Exception e){
				e.printStackTrace();
			} 
		//分发转向
		  if (register == true){
            	System.out.println("注册成功");
    			response.getWriter().write("注册成功,1秒后调到主页");
    			response.setHeader("refresh", "1；url="+request.getContextPath()+"/index.jsp");
            } else {
            	System.out.println("用户名或邮箱已存在");
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
