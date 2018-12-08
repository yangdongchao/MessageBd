<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
        .button {
    background-color: purple; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
            -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
            border-radius: 6px;
    }
        .button:hover{
             background-color: #4CAF50; /* Green */
             color: white;
        }

        .formDiv
        {
            width: 300px;
            height: 500px;
            border: 2px solid  honeydew;
            border-radius: 5px;
            margin-top: 100px;
            margin-left: 200px;
            background-image: url("image/rgbg.jpg");
            background-size: 100% 100%;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }
        .userDiv
        {
            margin-top: 20px;
            margin-left: 5px;
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
        .mainDiv
        {
            background-image: url("image/timg.jpg");
            width: 100%;
            height: 100%;
        }
    </style>
    <meta charset="UTF-8">
    <title>注册账号</title>
</head>
<body class="mainDiv">
<div id="mainBody" >
    <div id="formDiv" class="formDiv">
        <form action="/Board/RegisterService" method="get">
            <div id="userDiv" class="userDiv">
            <input type="text" name="id"  class="input" placeholder="输入电话号码"> <br>
            </div>
             <div id="usernameDiv" style="margin-top: 15px;margin-left: 5px">
            <input type="text" name="name"  class="input" placeholder="输入昵称"> <br>
            </div>

            <div style="margin-top: 15px; margin-left:5px; ">
                <input type="password" name="password"  class="input" placeholder="输入密码"> <br>
            </div >
            <div style="margin-top: 15px; margin-left:5px; ">
                <input type="password" name="tpassword"  class="input" placeholder="确认密码"> <br>
            </div >
            <div style="margin-left: 5px;margin-top: 15px">
                <input type="text" name="sex" class="input" placeholder="男/女">
            </div>
            <div style="margin-top: 15px; margin-left:32px; ">
            <input type="submit" value="立即注册" class="button" ></input>
            </div>
        </form>
    </div>
</div>
<%
	String MessageSuc =(String) request.getAttribute("phone");
	//String MessageFail =(String) request.getAttribute("MessageFail");
	if(MessageSuc!=null){
%>
<script type="text/javascript" language="javascript">
                    alert("<%=MessageSuc %>");
</script>
<%
 request.removeAttribute("phone");
} %>
</body>
</html>