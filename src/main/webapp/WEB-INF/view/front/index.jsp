<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="dist/css/carousel.css">
</head>
<body>
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
				<a class="navbar-brand" href="#"><img alt="" src="/dist/images/graylogo.png" style="width: 65px; height: 50px; float: left; margin-left: 30px;"></a>
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
						<li><a href="/login/to">${sessionScope.user.nickName }</a></li>
					</ul>
				</c:if>
			</div>
		</div>
	</nav>

	<div class="container" style="margin-top: 70px;">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<div class="jumbotron">
					<h1>你好，世界！</h1>
					<p>你好，世界！</p>
				</div>
				<div class="row">
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
					<div class="col-xs-12 col-lg-12">
						<h4>宫同学，快来看看吧</h4>
						<p>宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！宫同学的水平已经饥渴难耐了！</p>
					</div>
				</div>
				<!--/row-->
			</div>

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item active">标签</a>
					<a href="#" class="list-group-item">宫同学</a> 
					<a href="#" class="list-group-item">欣同学</a>
					<a href="#" class="list-group-item">康同学</a>
					<a href="#" class="list-group-item">清同学</a>
					<a href="#" class="list-group-item">杨同学</a>
					<a href="#" class="list-group-item">平同学</a>
				</div>
			</div>
		</div>

		<hr>
		<footer>
			<p>&copy; 2016   个人网站, qiuk.</p>
		</footer>

	</div>
</body>
</html>