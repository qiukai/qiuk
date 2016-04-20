<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="dist/css/login.css">
</head>
<body>
	<a href="">
		<button type="button" class="btn btn-default" id="back">
  			<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> 返回
		</button>
	</a>
	<div class="container">
		<form class="form-signin" action="login/go" id="form_id" method="post">
			<h2 style="text-align: center;">登&nbsp;&nbsp;录</h2>
			<label for="inputEmail" class="sr-only">请输入邮箱</label>
			<input type="email" id="inputEmail" class="form-control" placeholder="请输入邮箱" name="email" required autofocus>
			<label for="inputPassword" class="sr-only">请输入密码</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" name="password" required>
			<button class="btn btn-lg btn-primary btn-block" type="button" id="login">登录</button>
		</form>
	</div>
	<%@include file="../common/alert.jsp" %>
	<script type="text/javascript" src="dist/js/md5.js"></script>
	<script type="text/javascript" src="dist/js/front/login.js"></script>
</body>
</html>