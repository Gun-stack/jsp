<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dto.User" %>
<%
	User us = (User)request.getAttribute("u");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> //유진언니바보
    body {
        margin: 0 auto;
        
    }

    .container {
        padding: 10px;
        border: 1px solid;
        width: 280px;
    }

    .header {
        height: 40px;
    }

    .row {
        height: 30px;
    }

    .title {
        width: 70px;
        float: left;
        font-weight: bold;
    }

    .input {
        float: left;
    }

    input[type='submit'] {
        font-weight: bold;
        width: 120px;
        background-color: lightgrey;
    }
</style>
</head>
<body>
	<div>
   		<br>
        <div class="header" style="text-align: center;">
            <h3>회원정보 조회</h3>
        </div>

        <div class="container" id='result'>
            <div class="row">
                <div class="title">아이디</div>
                <div class="input"><input type="text" name="id" id='id' disabled value=<%=us.getId() %>></div>
            </div>
            <div class="row">
                <div class="title">비밀번호</div>
                <div class="input"><input type="password" name="password" id='password' disabled value=<%=us.getPassword() %>></div>
            </div>
        </div>
    </div>
</body>
</html>