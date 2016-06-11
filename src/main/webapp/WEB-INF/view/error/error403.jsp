<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>qiuk</title>
<link rel="shortcut icon" href="images/logo.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
</head>

<body>
	<img src="dist/images/error/403.jpg" class="img-responsive"
		style="margin: auto; margin-top: 100px;" onclick="history.go(-1);">
</body>
</html>
