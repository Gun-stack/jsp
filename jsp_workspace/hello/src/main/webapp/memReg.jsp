<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .container{
            border: 1px;
            border-style: solid;
            border-color: black;
            width: 300px;
            margin: 10px auto;
        }
        .top{
            margin: 10px auto;
            text-align: center;
        }
        .middle{
            display: flex;
            flex-direction: row;
            overflow: hidden;
            margin-bottom: 5px;
            margin: 5px;          
        }
        #left{
            width: 100px;
            float: left;
            margin-right: 1px;
        }
        #right{
            width: 150px;
            float: left;
        }
        .bot{
            width: 280px;
            margin: 10px;
            margin-left:35%;
        }
    </style>




</head>
<body>


 <div class="top"><h1>회원가입</h1></div>
    <div class="container">
    <div class="middle">
        <div id="left">회원명 : </div>
        <div id="right"> <%=request.getParameter("name") %></div>
    </div>
    <div class="middle">
        <div id="left">주소 : </div>
        <div id="right"> <%=request.getParameter("address")%></div>
    </div>
    <div class="middle">
        <div id="left">전화번호 : </div>
        <div id="right"> <%=request.getParameter("tel") %></div>
    </div>
    <div class="middle">
        <div id="left">취미 : </div>
        <div id="right"> <%=request.getParameter("hobby") %></div>
    </div>
</div>
</body>
</html>