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
		Object errorMsg = request.getAttribute("errorMsg");
	%>
	<div class="container">
		<div class="page-header text-center">
			<h3>메시지 전송 실패!</h3>
		</div>
		<div class="col-md-6 col-md-offset-3 ">
			<img class="img-responsive  center-block" width="300" height="500"
				src="img/fail.png" alt="실패" /> <br>
			<h5>실패내용</h5>
			<p><%=(String) errorMsg%></p>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>