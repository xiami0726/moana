<%@page import="com.movietickets.service.MovieTicketService"%>
<%@page import="com.movietickets.service.impl.MovieTicketServiceImpl"%>
<%@page import="com.movietickets.domain.MovieTicket"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*,java.sql.SQLException" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="refresh" content="3"> -->
<title>抢购页面</title>

<%--
 <script type="text/javascript">
 	setInterval(function(){
 		window.location.reload(true);
	}, 3000);
 </script> 
 --%>
 
<script language="javascript"> 
 	var xhr;  
 //创建XMLHttpRequest对象         
   function createXMLHttpRequest() {  
		   if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			   xhr=new XMLHttpRequest();
		   } else  {// code for IE6, IE5
			   xhr=new ActiveXObject("Microsoft.XMLHTTP");
		   }  
	}  
//发送请求函数  
function sendRequest() {  
 	createXMLHttpRequest();  
       var url = "auto.jsp";  
       xhr.open("GET", url, true);  
       xhr.onreadystatechange = processResponse;//指定响应函数  
       xhr.send(null);  // 发送请求  
}  
// 处理返回信息函数  
   function processResponse() {  
    if (xhr.readyState == 4) { // 判断对象状态  
        if (xhr.status == 200) { // 信息已经成功返回，开始处理信息    
        		DisplayTicketNum();
   				setTimeout("sendRequest()", 3000);  
           } else { //页面不正常  
               window.alert("您所请求的页面有异常。");  
           }   tomcat
       }  
   }  
   function DisplayTicketNum() { 
	   var name = xhr.responseXML.getElementsByTagName("name")[0].firstChild.nodeValue;

	   	for (var i = 0 ; i < name;++i){
	    		var count = xhr.responseXML.getElementsByTagName("count")[i].firstChild.nodeValue;
	  			document.getElementsByClassName("movieTicketNum")[i].innerHTML = count; 
	   	}

	}
   
 </script>

</head>
<body  onload = sendRequest()>

<table width=85% border=1>
  <tr>
     <td>电影编号</td>
     <td>电影名称</td>
     <td>电影票数量</td>
     <td>电影开始时间</td>
     <td>电影结束时间</td>
  </tr>

<%
  //利用while循环输出各条记录
 
  MovieTicketService impl = new MovieTicketServiceImpl();
  List<MovieTicket> rs = impl.getAllMovieTicktInfo();
  if (rs != null)
  for (int i = 0; i < rs.size(); ++i)
  {
%>
<tr>
<%--      <td name="movieId" ><%=rs.getString("movieId") %></td>  --%>
	<form action="buyticket?action=buyticket" method="post"> 
	   <td><input type="text" name="movieId" value=<%=rs.get(i).getMovieId()%>></td> 
	   <td><%=rs.get(i).getMovieName()%></td>
<%-- 	   <td class="movieTicketNum"><%= rs.get(i).getMovieticketNum()%></td> --%>
	   <td class="movieTicketNum"></td>
	   <td><%=rs.get(i).getStartTime()%></td>
	   <td><%=rs.get(i).getEndTime()%></td>
	   <td>		
			<input type="submit" value="抢购"/><br/>	
	   </td>
   </form>
   
</tr>
<%
}
%>

</table>
</body>
</html>