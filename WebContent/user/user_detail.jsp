<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看詳情</title>
<style type="text/css">
.wrapper{
  width:250px;
  height: auto;
  margin: 0 auto;
}
.wrapper>p{
  font-size:18px;
}


</style>
</head>
<body>
<h1 align="center">用戶详情</h1>
<div class="wrapper">
<p>用户ID:&nbsp;&nbsp;${requestScope.user.userId}</p>
<p>用户名:&nbsp;&nbsp;${requestScope.user.userName}</p>
<p>密码:&nbsp;&nbsp;${requestScope.user.password}</p>
<p>真实姓名:&nbsp;&nbsp;${requestScope.user.realName}</p>
<p>性别:&nbsp;&nbsp;${requestScope.user.sex==1?"男":"女"}</p>
<p>出生日期:&nbsp;&nbsp;${requestScope.user.birthday}</p>
<a href="http://localhost:8080/JF190902/UserServlet?userAction=list">返回用户列表</a>
</div>
</body>
</html>