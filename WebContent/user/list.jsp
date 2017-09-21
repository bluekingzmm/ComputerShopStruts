<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/button.css"></c:url>'>
<script src="<c:url value="/lib/jquery-1.7.2.min.js"/>" type="text/javascript"></script>


<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>

</head>

<%@include file="/admin/Basion.jsp"%>
<body>
	<div class="content">

		<div class="header">

			<h1 class="page-title">Users</h1>
	</div>

		<ul class="breadcrumb">
			<li><a href="index.html">Home</a> <span class="divider">/</span></li>
			<li class="active">Users</li>
	</ul>
		<form action='<c:url value="/searchNameUser"></c:url>' method="post">
			<div id="search"><br /> <input type="text"
				name="user.user_name" placeholder="search...." /> <input
				type="submit" value="查询"
				class="button button-primary button-rounded button-small" /></div>
	</form>

		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar">

					<div class="btn-group"></div>
			</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>序号</th>
								<th>用户名</th>
								<th>性别</th>
								<th>操作</th>
								<th>操作</th>

								<th style="width: 26px;"></th>
						</tr>
					</thead>
						<tbody>

							<c:forEach items="${uList}" var="user" varStatus="status">
								<tr>
									<td>${(pageNo-1)*pageSize+status.count}</td>
									<td>${user.user_name }</td>
									<td>${user.sex }</td>
									<td><a
										href='<c:url value="/recycleBinUser?user.user_id=${user.user_id }&user.status=-1"></c:url>'><i
											class="icon-remove"></i></a></td>
									<td><a
										href='<c:url value="/showUser?user.user_id=${user.user_id }"></c:url>'>查看</a></td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
				<div class="pagination">
					<ul>
						<li><a>共有${count }条记录，当前第${pageNo}/${totalPage}页</a></li>
						<li><c:if test="${pageNo!=1 }">
								<a href='<c:url value="/listUser?pageNo=1"></c:url>'>首页</a>
							</c:if> <c:if test="${pageNo==1 }">
								<a href="javascript:void(0);" style="color: #cfcfcf">首页</a>
							</c:if></li>
						<li><c:if test="${pageNo!=1 }">
								<a
									href="<c:url value="/listUser?pageNo=${pageNo<1?pageNo:pageNo-1}"></c:url>">上一页</a>

							</c:if> <c:if test="${pageNo==1 }">

								<a href="javascript:void(0);" style="color: #cfcfcf;">上一页</a>

							</c:if></li>
						<li><c:if test="${pageNo!=totalPage }">

								<a
									href="<c:url value="/listUser?pageNo=${pageNo>totalPage?pageNo:pageNo+1}"></c:url>">下一页</a>
							</c:if> <c:if test="${pageNo==totalPage }">
								<a href="javascript:void(0);" style="color: #cfcfcf;">下一页</a>
							</c:if></li>
						<li><c:if test="${pageNo!=totalPage }">
								<a href="<c:url value="/listUser?pageNo=${totalPage}"></c:url>">尾页</a>
							</c:if> <c:if test="${pageNo==totalPage }">

								<a href="javascript:void(0)" style="color: #cfcfcf;">尾页</a>

							</c:if></li>
				</ul>
			</div> <footer>
				<hr>
				<p>&copy; 2016 <a href="#" target="_blank">zmm</a></p>
			</footer>

		</div>
	</div>
</div>
</body>
</html>