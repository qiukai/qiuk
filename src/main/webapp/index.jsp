<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" href="dist/images/logo.ico" type="image/x-icon">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
<!--     <meta http-equiv="refresh" content="0; URL=/index"> -->
</head>
<body onload="location.href = '/index'">
</body>
</html>
