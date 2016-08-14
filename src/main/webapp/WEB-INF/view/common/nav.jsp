<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#"><img class="img-responsive" src="/dist/images/graylogo.png" style="height: 50px; float: left;"></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li>
						<form class="navbar-form">
							<div class="form-group">
								<input type="text" placeholder="请输入关键字" class="form-control"
									style="width: 350px;">
							</div>
						</form>
					</li>
				</ul>
				<c:if test="${sessionScope.user == null }">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/login/to">登录</a></li>
						<li><a href="/register/to">注册</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.user != null }">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						  <a class="dropdown-toggle" type="button" id="personMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						    ${sessionScope.user.nickName }&nbsp;
						    <span class="caret"> </span>
						  </a>
						  <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="personMenu">
						    <li><a href="/person">个人信息</a></li>
						    <li><a href="#">我的帖子</a></li>
						    <li><a href="#">我的标签</a></li>
						    <li><a href="#">修改密码</a></li>
						    <li><a href="#">退出</a></li>
						  </ul>
						</li>
					</ul>
				</c:if>
			</div>
		</div>
	</nav>