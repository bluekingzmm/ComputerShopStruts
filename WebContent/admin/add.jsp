<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<style type="text/css">
fieldset {
	border: none;
	text-align: center;
}


.errorMessage{
color: black;
list-style-type: none;
}

.table {
	border: 2px solid #808080;
	width: 800px;
	height: auto;
}

.table tr {
	width: 200px;
	text-align: center;
	background: #dba8bd;
	height: 50px;
}

.table tr:HOVER {
	background: #f0f0f0;
}
</style>

</head>
<%@include file="/admin/Basion.jsp"%>
<body class="">
	<div class="content">

		<div class="header">

			<h1 class="page-title">Admin</h1>
	</div>

		<ul class="breadcrumb">
			<li><a href="#">Home</a> <span class="divider">/</span></li>
			<li class="active">admin</li>
	</ul>

		<div class="container-fluid">

			<div class="">
			<s:fielderror></s:fielderror>
				<form method="post"
				action='addAdmin'>
				<input type="hidden" name="admin.status" value="1">
					<table>
						<tr><td>请输入用户名：</td>
							<td>
							<s:textfield name="admin.admin_name"  placeholder="请输入用户名"></s:textfield>
							</td></tr>
						<tr><td>请输入密码：</td>
							<td>
								<s:textfield name="admin.admin_password" placeholder="请输入密码"></s:textfield>
							</td>
						
							</tr>
				</table>
					<fieldset><span>

							<button class="btn btn-primary" type="submit"><i
								class="icon-plus"></i> 添加</button>

					</span> <span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

				</fieldset>

			</form>

		</div>
	</div>
</div>

</body>
</html>