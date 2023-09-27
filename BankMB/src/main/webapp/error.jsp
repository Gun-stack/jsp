<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.header {
	height: 40px;
}
</style>

</head>
<body>
	<table style="width:100%;">
			<thead>
				<tr>
					<td>
						<%pageContext.include("header.jsp"); %>
					</td>
				</tr>
			</thead>
		</table>

<div class="header" style="text-align: center;">
	<h3><%= request.getAttribute("err") %></h3>
</div>


 
 
 
 
</body>
</html>