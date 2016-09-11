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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>qiuk</title>
<link rel="shortcut icon" href="dist/images/logo.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="dist/css/base.css">
<script type="text/javascript" src="dist/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="dist/js/bootstrap.js"></script>
<script type="text/javascript" src="dist/js/base.js"></script>