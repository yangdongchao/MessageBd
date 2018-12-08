<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="cn.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言板</title>
<style type="text/css">
         .button {
    background-color: purple; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
             width: 95%;
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
            background-image: url("image/rgbg.jpg");
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
        background-image: url("image/mgbackg.jpg");
    }
    </style>
</head>
<body class="Body">
<%
	User user = new User();
	user =(User) request.getSession().getAttribute("login");
	String times =(String) request.getSession().getAttribute("times");
%>
<div id="MessageDiv" class="MessageDiv">
	   <button class="buttonDD"  id="bnt" onclick="fun()" style="width: 30%;margin-left: 10px;margin-top:20px" >注销</button>
       <a class="buttonDD" href="http://localhost:8080/Board/History.jsp" style="width: 40%;margin-left: 10px;margin-top:20px">查看留言历史</a>
    <div id="user" style="margin-left: 15px;margin-top: 30px">
        <div class="DivU">用户名 :   &nbsp;  &nbsp;  &nbsp;  <%=user.getName() %></div> <br>
        <div class="DivU">已留言 :   &nbsp;   &nbsp; &nbsp; <%= times%></div> <br>
    </div>
    <form method="get" action="/Board/MessageService">
        <div style="margin-left: 15px;margin-top: 30px">
            <input type="text" name="title" class="input" placeholder="标题">
        </div>

        <div style="margin-left: 15px;margin-top: 30px">
            <textarea name="content" class="inputContent"></textarea>
        </div>

        <div style="margin-left: 15px;margin-top: 30px">
            <input type="submit" value="留言" class="button">
        </div>
    </form>

</div>
<%
	String MessageSuc =(String) request.getAttribute("MessageSuc");
	String MessageFail =(String) request.getAttribute("MessageFail");
	if(MessageSuc!=null){
%>
<script type="text/javascript" language="javascript">
                    alert("<%=MessageSuc %>");
</script>
<%
 request.removeAttribute("MessageSuc");
} %>
<% 
	if(MessageFail!=null){
		
%>
<script type="text/javascript" language="javascript">
                    alert("<%=MessageFail %>");
                    
</script>
<%
  request.removeAttribute("MessageFail");
} 


%>
<script type="text/javascript">
function fun() {

	 <%
     //request.getSession().removeAttribute("login");
    %>
    window.open("http://localhost:8080/Board/Login.jsp");
 }
</script>
</body>
</html>