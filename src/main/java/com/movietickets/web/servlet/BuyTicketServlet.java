package com.movietickets.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movietickets.dao.OrderRecordDao;
import com.movietickets.dao.impl.OrderRecordDaoImpl;
import com.movietickets.dao.impl.UserDaoImpl;
import com.movietickets.domain.MovieTicket;
import com.movietickets.domain.OrderRecord;
import com.movietickets.domain.User;
import com.movietickets.service.MovieTicketService;
import com.movietickets.service.OrderRecordService;
import com.movietickets.service.impl.MovieTicketServiceImpl;
import com.movietickets.service.impl.OrderRecordServiceImpl;
import com.movietickets.utils.SendMail;



/**
 * Servlet implementation class BuyTicketServlet
 */
public class BuyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String action = request.getParameter("action");  
		boolean buyticket = false;
		if("buyticket".equals(action)){
			try{
			    String buyTicket = request.getParameter("buyticket");  
			    
			    MovieTicketService ticketImpl  = new MovieTicketServiceImpl();
			    UserDaoImpl userImpl = new UserDaoImpl();
			    OrderRecordService orderImpl = new OrderRecordServiceImpl();
			    
			    String strmovieId = request.getParameter("movieId");
			    int movieId = Integer.parseInt(strmovieId);
			    
			    
			    //获取cookie的信息
		        //每次浏览器发送请求，都会将所有的cookie信息通过报头发送给服务器
		        Cookie[] cookies = request.getCookies();
		        String userName = "";
			    
		        //遍历cookie数组，通过cookie的name，查找cookie的value
		        if(cookies!=null && cookies.length>0){
		            for(int i=0;i<cookies.length;i++){
		                //如果cookie的名字和username一致，就获取cookie中的值
		                if("userName".equals(cookies[i].getName())){
		                    //将从cookie中获取到的值放在uname中
		                	userName = cookies[i].getValue();              
		                }

		            }

		            if(userName.length()>0){
		                System.out.println("保存在Cookie中的用户名："+userName);
		            }else{
		            	System.out.println("对不起，你要的cookie信息不存在！");
		            }
		        }  
		        
			    
			    User user1 = null;
			    User user2 = null;
			    if(userName.length()>0){
			    	user1 = userImpl.selectByEmail(userName);
			    	user2 = userImpl.selectByUserName(userName);
			    }
			    
//			    System.out.println("user1 == " + user1);
//			    System.out.println("user2 == " + user2);
			    User user = null;
			    if (user1 != null){
			    	user = user1;
			    } else if (user2 != null){
			    	user = user2;
			    }
			    
			    
			    if (ticketImpl != null && user != null){
			    	
			    	if(ticketImpl.buyMovieTicket(movieId, new Date()) == true){
				    	MovieTicket ticket = ticketImpl.getMovieTicketInfoByMovieId(movieId);
				    	buyticket = true;
				    	
		
				    	Date current = new Date();
				    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    	String time = sdf.format(current);
				    	
				    	String emailMsg = "尊敬的用户"+ user.getUserName()+"，您好，您在 "+ time + "成功抢购'"+ticket.getMovieName()+"' 电影票一张";
				    	String email = user.getEmail();
						SendMail.sendMail(email, emailMsg);
						
						orderImpl.GenerateOrder(user.getUserId(), movieId, 1);
			    	}
					
			    }
			    
			} catch(Exception e){
				e.printStackTrace();
			} 
			
		}
		//分发转向
	  if (buyticket == true){
	    	System.out.println("抢购成功");
			response.getWriter().write("抢购成功,1秒后调到主页");
			response.setHeader("refresh", "1；url="+request.getContextPath()+"/buyTicket.jsp");
	    } else {
	    	System.out.println("抢购失败");
	    	response.setHeader("refresh", "1；url="+request.getContextPath()+"/buyTicket.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
