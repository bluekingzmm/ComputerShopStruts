<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<script src="<c:url value="/lib/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
</head>
<%@include file="/admin/Basion.jsp"%>
<body class="">
	<div class="content">

		<div class="header">

			<h1 class="page-title">BrandList</h1>
	</div>

		<ul class="breadcrumb">
			<li><a href="index.html">Home</a> <span class="divider">/</span></li>
			<li><a href="users.html">Screen</a> <span class="divider">/</span></li>
	</ul>

		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar"></div>
				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">屏幕尺寸列表</a></li>
				</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home"><c:forEach
								items="${sList}" var="s">
								<form id="tab" method="post"
									action='<c:url value="/modifyScreenCategory"></c:url>'>
									<input type="hidden" name="screen.screen_id" value="${s.screen_id }" /> <label>屏幕尺寸</label>
									<input type="text" value="${s.screen_name}" class="input-xlarge"
									name="screen.screen_name"> <input type="submit" value="更新" />
								</form>
								<a
									href="<c:url value="/deleteScreenCategory?screen.screen_id=${s.screen_id}"></c:url>">删除</a>
							<br>
							</c:forEach>
							<form action="<c:url value="/addScreenCategory"></c:url>" method="post"> <input
								type="text" name="screen.screen_name"><br> <input type="submit"
								value="添加" /></form> <span>${msg}</span></div>

				</div>
			</div>

		</div> <footer>
			<hr>
			<p>&copy; 2016 <a href="#" target="_blank">zmm</a></p>
		</footer>

	</div>
</div>
</body>
</html>