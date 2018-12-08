<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
        .button {
    background-color: #4CAF50; /* Green */
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
             background-color: purple; /* Green */
             color: white;
        }

        .formDiv
        {
            width: 300px;
            height: 400px;
            border: 2px solid  honeydew;
            border-radius: 5px;
            margin-top: 100px;
            margin-left: 200px;
            background-image: url("image/qq3.jpg");
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }
        .userDiv
        {
            margin-top: 30px;
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
         .inputCode
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
            background-image: url("image/Login2.jpeg");
            width: 1622px;
            backgroud-size:100% 100%;
            height: 940px;
        }
        .A{
            font-size: 15px;
            font-family: "Arial Black";
            color: blueviolet;
            margin-top: 2px;
            margin-left: 20px;
           text-align: right;
        }
         .Image{
            font-size: 15px;
            font-family: "Arial Black";
            color: blueviolet;
            margin-top: 7px;
            margin-left: 10px;
        }

    </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/DrawImage?"+Math.random();
    }
    </script>
</head>
<body class="mainDiv">
<div id="mainBody" >
    <div id="formDiv" class="formDiv">
        <form action="/Board/LoginService" method="get">
            <div id="userDiv" class="userDiv">
            <input type="text" name="id"  class="input" placeholder="输入账号"> <br>
            </div>


            <div style="margin-top: 20px; margin-left:5px; ">
            <input type="password" name="password"  class="input" placeholder="输入密码"> <br>
            </div >

             <div style="margin-top: 20px; margin-left:5px; ">
            <input type="text" name="validateCode"  class="inputCode" placeholder="输入验证码">
                 <img alt="验证码" src="${pageContext.request.contextPath}/DrawImage" id="validateCodeImg" onclick="changeImg()" class="Image">
               <a href="javascript:void(0)" onclick="changeImg()" class="A" > 看不清?换一张</a>
            </div >
            <div style="margin-top: 20px; margin-left:32px; ">
            <input type="submit" value="登 录" class="button" ></input>


                <a href="http://localhost:8080/Board/Register.jsp" class="button" style="margin-left: 40px">注 册</a>
            </div>
        </form>
    </div>
</div>
<%
	String errorValidCode =(String) request.getAttribute("errorValidCode");
	String errorPassWord =(String) request.getAttribute("errorPassword");
	if(errorValidCode!=null){
%>
<script type="text/javascript" language="javascript">
                    alert("<%=errorValidCode %>");
</script>
<%
 request.removeAttribute("errorValidCode");
} %>
<% 
	if(errorPassWord!=null){
		
%>
<script type="text/javascript" language="javascript">
                    alert("<%=errorPassWord %>");
</script>
<%
  request.removeAttribute("errorPassword");
} %>
</body>
</html>