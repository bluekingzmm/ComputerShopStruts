<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>管理员登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/normalize.css"></c:url>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/logindefault.css"></c:url>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/loginstyles.css"></c:url>' />

<script src='<c:url value="/js/prefixfree.min.js"/>'></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="css/loginstyles.css"/>">
<style type="text/css">
.errorMessage {
	color: yellow;
	list-style-type: none;
}
</style>
</head>
<!--后台登录  -->

<body>
	<div id="logo">
		<h1 class="hogo"><i> Administrator Login</i></h1>
</div>

	<section class="stark-login"> 
	
	<form action='<c:url value="/loginAdmin"></c:url>'
		method="post">

		<div id="fade-box"><input type="text" name="admin.admin_name"
			id="username" placeholder="Adminname" required> <input
			type="password" placeholder="Password" required
			name="admin.admin_password">
			<fieldset style="border: none;">
				<button>Log In</button> <br /> <span
				style="color: red; font-size: 14px;">${msg } <s:fielderror></s:fielderror></span>

		</fieldset></div>
	</form>
	<div class="hexagons"><span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <br> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <br> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <br>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <br>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
		<span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
	</div>
</section>

	<div id="circle1">
		<div id="inner-cirlce1">
			<h2></h2>
	</div>
</div>
	<ul>
		<li>注册</li>
</ul>
	<header class="htmleaf-header">
	<h1>电脑网上商城后台登录 <span>Welcome to our hotel</span></h1>
	<div class="htmleaf-links"><a
		class="htmleaf-icon icon-htmleaf-home-outline" href="<c:url value="/FirstAction"/>"
		title="首页" target="_blank"><span> 首页</span></a> <a
		class="htmleaf-icon icon-htmleaf-arrow-forward-outline"
		href="<c:url value="/admin/login.jsp"/>" title="返回" target="_blank"><span>
				注册</span></a></div>
</header>
</body>
</html>