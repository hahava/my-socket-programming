<%@page import="com.server.EmailDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>네트워크 과제</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%
		Object obj = request.getAttribute("email");
		EmailDTO email = (EmailDTO) obj;
	%>
	<div class="container">
		<div class="page-header text-center">
			<h3>메시지 전송 성공!</h3>
		</div>
		<div class="col-md-6 col-md-offset-3 ">
			<img class="img-responsive  center-block" width="300" height="500"
				src="img/success.png" alt="실패" />
			<h4 class="bold">받는 이</h4>
			<p>:<%=email.getRcpt()%></p>
			<h4 class="bold">보내는 이</h4>
			<p>:<%=email.getFrom()%></p>
			<h4 class="bold">이름</h4>
			<p>:<%=email.getName()%></p>
			<h4 class="bold">제목</h4>
			<p>:<%=email.getTitle()%></p>
			<h4 class="bold">메일내용</h4>
			<p>:<%=email.getContent()%></p>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>