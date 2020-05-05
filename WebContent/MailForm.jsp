<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네트워크 과제</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script language="javascript">
	<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>

<script type="text/javascript">
	function verifyemail() {
		if (document.mailform.InputEmailrcpt.value == "") {
			alert("보내는 사람을 입력해주세요!")
			document.mailform.InputEmailrcpt.focus();
			return false;
		} else if (document.mailform.InputEmailfrom.value == "") {
			alert("받는 사람을 입력해주세요!")
			document.mailform.InputEmailfrom.focus();
			return false;
		} else if (document.mailform.username.value == "") {
			alert("보내는 사람의 이름을 입력해주세요!")
			document.mailform.username.focus();
			return false;
		} else if (document.mailform.title.value == "") {
			alert("메일의 제목을 입력해주세요!")
			document.mailform.title.focus();
			return false;
		} else if (document.mailform.content.value == "") {
			alert("내용을 입력해주세요!")
			document.mailform.content.focus();
			return false;
		} else {
			document.mailform.submt();
			return true;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				이메일보내기 <small>네트워크 과제</small>
			</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form name="mailform" action="EmailSender" method="get" onsubmit="verifyemail();return false">
				<label>받는 사람</label> <input type="email" class="form-control" id="InputEmailrcpt" placeholder="이메일 주소" name="rcpt"> <br> <label>보내는 사람</label> <input type="email" class="form-control" id="InputEmailfrom" placeholder="이메일 주소" name="from"> <br> <label>이름</label> <input type="text" class="form-control" id="username" placeholder="이름을 입력해 주세요" name="name"> <br> <label>제목</label> <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력해 주세요"> <br> <label>내용</label>
				<textarea class="form-control" rows="20" name="content" placeholder="메일 내용을 입력합니다."></textarea>
				<br>
				<div class="form-group text-right">
					<input type="submit" class="btn btn-info" value="메일보내기">
				</div>
			</form>

		</div>
	</div>
	<hr>

	<footer>
	<div class="container">
		<h5 style="display: inline-block; margin-bottom: 30px;">
			이하린 <small>15010924</small>
		</h5>
		<h5 style="display: inline">
			이가경 <small>15010958</small>
		</h5>
		<h5 style="display: inline">
			정예지 <small>15010973</small>
		</h5>
	</div>
	</footer>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>