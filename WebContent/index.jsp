<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 <title>Login</title>
 <style>
  div#container{
  position:absolute;
  width:100%;height:100%;
  background-color:#FcF8F7;
  }
  div#login{
  position:absolute;
  width:270px;heigth:400px;
  background-color:#AABBFF;
  left:40%;top:25%;
  border-radius: 8px;
  }
 </style>
 </head>
 <body>
  <div id="container">
    <div id="login">
      <br />
      <form action="MyUniqueServlet" method="get">
        <label>&nbsp;&nbsp;用户名:<input type="text" id="userName" /></label><br /><br />
        <label>&nbsp;&nbsp;密 &nbsp;码:<input type="text" id="password" /></label><br /><br />
        <label>&nbsp;&nbsp;验证码:<input type="text" id="checkWord" width="80px" /></label><br /><br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;<input type="submit" id="submit" value="登陆" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" id="cancel" value="取消" />
      </form>
      <br />
    </div>
  </div>
 </body>
</html>