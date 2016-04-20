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
		<form class="form-signin" action="register/go" method="post" id="form_id">
			<h2 style="text-align: center;">注&nbsp;&nbsp;&nbsp;&nbsp;册</h2>
			<input type="email" class="form-control" name="email" placeholder="请输入邮箱" required>
			<input type="text" class="form-control" name="nickName" placeholder="请输入昵称" required>
			<input type="password" class="form-control" name="password" placeholder="请输入密码" required>
			<input type="password" class="form-control" id="password_id" placeholder="请输入重复密码" required>
			<button type="button" class="btn btn-lg btn-primary btn-block" id="register_id">注册</button>
		</form>
	</div>
	<%@ include file="../common/alert.jsp"%>
	<script type="text/javascript" src="dist/js/md5.js"></script>
	<script type="text/javascript" src="dist/js/front/register.js"></script>
</body>
</html>