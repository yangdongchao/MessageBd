<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="cn.model.Message" %>
<%@page import="cn.Dao.*" %>
<%@page import="java.util.*" %>
<%@page import="cn.model.User" %>

<html>
  <head>  
    <title>留言板界面</title>
    <style type="text/css">
         .button {
    background-color: purple; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
             width: 20%;
    font-size: 16px;
            -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
            border-radius: 6px;
    }
        .button:hover{
             background-color: brown; /* Green */
             color: white;
        }

         .MessageDiv
        {
            width: 400px;
            height: 700px;
            border: 2px solid  honeydew;
            border-radius: 5px;
            margin-top: 100px;
            margin-left: 200px;
            background-image: url("rgbg.jpg");
            background-size: 100% 100%;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }
         .input
        {
             box-sizing: border-box;
            text-align:center;
            font-size:1.4em;
             height:2.3em;
            border-radius:4px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            -web-kit-appearance:none;
            -moz-appearance: none;
            display:block;
            outline:0;
            padding:0 1em;
            text-decoration:none;
            width:98%;
        }
         .inputContent
        {
             box-sizing: border-box;
            text-align:center;
            font-size:1.4em;
             height:13em;
            border-radius:4px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            -web-kit-appearance:none;
            -moz-appearance: none;
            display:block;
            outline:0;
            padding:0 1em;
            text-decoration:none;
            width:98%;
        }
		 .DivU{
            width: 95%;
            height: 30px;
            border: 2px dashed purple;
            color: aquamarine;
             text-align:center;
        }
           .buttonDD {
    background-color: purple; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
             width: 21%;
              // height: 30px;
    font-size: 16px;
            -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
            border-radius: 6px;
    }
        .buttonDD:hover{
             background-color:aquamarine; /* Green */
             color: white;
        }
    .Body{
        background-image: url("newmg.jpg");
    }
    </style>
  </head>

  <body bgcolor="#ddd" >
  <div style="margin-left:35%;margin-top:100px;font-family:Microsoft YaHei">
    <a class="button" href="http://localhost:8080/Board/Message.jsp">留言</a>
   <form  action="leavemessage.jsp" method="post">
  		<table border="1">
  			<caption>留言历史</caption>
  			<tr><th>留言人姓名</th><th>留言时间</th>
				<th>留言标题</th><th>留言内容</th></tr>
  		<%
  		ArrayList<Message> al=new ArrayList<Message>();
			User user= (User)session.getAttribute("login");
			if(user==null)
			{
				response.getWriter().println(3);
			}
			MessageDb messageDb = new MessageDb();
			//response.getWriter().println(user.getId());
			al = messageDb.queryById(user.getId());
			//response.getWriter().println(al.size());
  			if(al.size()>0){
  				for(int i=0;i<al.size();i++){
  				Message mb= al.get(i);
  		%>
  				<tr><td><%= user.getName()%></td>
  					<td><%= mb.getDate() %></td>
  					<td><%= mb.getTitle() %></td>
  					<td><%= mb.getContent() %></td></tr>
  		<% 
  			}
  			}
  			else{
  				%>
  				
  				<tr>
  				 <tr><td><%= user.getName()%></td>
  				 <td>null</td>
  					<td>null</td>
  					<td>null</td>
  				</tr>
  				<%
  				
  			}
  		 %>
  		 </table>
  	</form>
    </div>
  </body>
</html>
