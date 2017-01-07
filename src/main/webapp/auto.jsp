<%@page import="com.movietickets.domain.MovieTicket"%>
<%@page import="java.util.List"%>
<%@page import="com.movietickets.service.impl.MovieTicketServiceImpl"%>
<%@page import="com.movietickets.service.MovieTicketService"%>
<%@ page contentType="text/html; charset=gb2312" %>
<%
response.setContentType("text/xml; charset=UTF-8");//设置输出信息的格式及字符集
response.setHeader("Cache-Control","no-cache");
out.println("<response>");
	
	MovieTicketService impl = new MovieTicketServiceImpl();
	List<MovieTicket> rs = impl.getAllMovieTicktInfo();
	out.println("<name>"+rs.size()+"</name>");
	if (rs != null)
		for (int i = 0 ;i < rs.size(); ++i){
			out.println("<count>" +rs.get(i).getMovieticketNum()+ "</count>");
		}
	out.println("</response>");
%> 

