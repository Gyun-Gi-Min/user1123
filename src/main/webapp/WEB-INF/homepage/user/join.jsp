<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String msg =(String) request.getAttribute("message");
%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
<h1>회원가입을 진행중입니다....</h1>
<!--post 방식으로 user/join에 보낼것-->
<% if (msg != null) {%>
    <div><%=msg%></div>  <!--만약 massage을 받아오면 회원가입 실패. msg를 보여줌
    그렇지 않고 못받아 오면 회원가입 성공.-->
<% } %>

<form action="/user/join" method="post">

    <div><input type="text" name="uid" placeholder="user id"></div>
    <div><input type="password" name="upw" placeholder="user password"></div>
    <div><input type="text" name="nm" placeholder="user name"></div>
    <div>
        gender : <label>woman <input type="radio" name="gender" value="0"></label>
        <label>man <input type="radio" name="gender" value="1"></label>
    </div>
    <div>
        <input type="submit" value="join">
    </div>


</form>



</body>
</html>
