<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<title>主要部分</title>
<!-- 后台主要部分 -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/lib/bootstrap/css/bootstrap.css"></c:url>'>
	
<link rel="stylesheet" type="text/css"
	href='<c:url value="/stylesheets/theme.css"></c:url>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<link rel="shortcut icon"
	href='<c:url value="/assets/ico/favicon.ico"></c:url>'>
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href='<c:url value="/assets/ico/apple-touch-icon-144-precomposed.png"></c:url>'>
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href='<c:url value="/assets/ico/apple-touch-icon-114-precomposed.png"></c:url>'>
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href='<c:url value="/assets/ico/apple-touch-icon-72-precomposed.png"></c:url>'>

</head>
<body>

	 <c:if test="${empty sessionScope.admin}">
		<script type="text/javascript">
			if (confirm("请先登录")) {
				location.href = "<c:url value='/admin/login.jsp'/>";
			} else {
				location.href = "<c:url value='/admin/login.jsp'/>";
			}
		</script>
	</c:if> 
	
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">
				<li><a href='<c:url value="/listMessageOrder"></c:url>'>我的消息</a></li>
				<li><a href='<c:url value="/admin/modifyPsw.jsp"></c:url>'>重置密码</a></li>
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i>你好！用户： ${sessionScope.admin.admin_name} <i
						class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li class="divider visible-phone"></li>
						<li>
						<s:a action="quitAdmin">退出登录</s:a>
						</li>
				</ul></li>

		</ul> <a class="brand" href="index.html"><span class="first">Computer</span>
				<span class="second">Shop</span></a>
	</div>
</div>
	<div class="sidebar-nav"><a href="#dashboard-menu"
		class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>商品管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a
				href='<c:url value="/listComputer"></c:url>'>商品列表</a></li>
			<li><a
				href='<c:url value="/createComputer"></c:url>'>添加商品</a></li>

	</ul> <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-briefcase"></i>管理员信息<span class="label label-info">+3</span></a>
		<ul id="accounts-menu" class="nav nav-list collapse">
					<li><a href='<s:url action="listAdmin"></s:url>'>管理员列表</a></li>
		
		<li><a href='<c:url value="/admin/modifyPsw.jsp"></c:url>'>重置密码</a></li>
			<li>
					<a href='<s:url action="recycleBinListAdmin"></s:url>'>回收站</a>
					</li>
	</ul> 
	<a href="#error-menu" class="nav-header collapsed"
		data-toggle="collapse"><i class="icon-exclamation-sign"></i>类别管理 <i
			class="icon-chevron-up"></i></a>
		<ul id="error-menu" class="nav nav-list collapse">
			<li><a
				href='<c:url value="/listBrandCategory"></c:url>'>品牌</a></li>
			<li><a href='<c:url value="/listCpuCategory"></c:url>'>Cpu列表</a></li>
			<li><a href='<c:url value="/listScreenCategory"></c:url>'>屏幕尺寸列表</a></li>
	</ul> <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-legal"></i>用户信息</a>
		<ul id="legal-menu" class="nav nav-list collapse">
			<li><a href="<s:url action="listUser"></s:url>">用户列表</a></li>
			<li><a
				href="<c:url value="/noActiveUser?user.status=0"></c:url>">账户未激活</a></li>
			<li><a
				href="<c:url value="/recycleBinListUser?user.status=-1"></c:url>">回收站</a></li>
	</ul> <a class="nav-header"
		href='<c:url value="/listOrder"></c:url>'><i
			class="icon-comment"></i>订单管理</a> <a href="#" class="nav-header"
		data-toggle="collapse"><i class="icon-dashboard"></i>销售管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href='<c:url value="/saleOrder"></c:url>'>销量排名</a></li>
			<li><a
				href='<c:url value="/echartsOrder"></c:url>'>销量图标</a></li>
	</ul> 
	<a href='<c:url value="/FirstAction"/>' class="nav-header"><i class="icon-comment"></i>前台首页</a>
</div>

	<script type="text/javascript" src="<c:url value="/lib/bootstrap/js/bootstrap.js"/>"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
</body>
</html>