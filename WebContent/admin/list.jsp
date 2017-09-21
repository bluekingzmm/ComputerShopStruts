<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示管理员首页</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<style type="text/css">
.errorMessage {
	color: black;
	list-style-type: none;
}
</style>
</head>
<%@include file="/admin/Basion.jsp"%>
<body>
	<script type="text/javascript">
		function deleteAdmin(id) {
			$.ajax({
				type : "POST",
				url : "<c:url value="/recycleBinAdmin"/>",
				data : "admin.id=" + id + "&admin.state=0",
				dataType : 'json',
				success : function(msg) {
					if (msg.error == '1') {
						alert('删除失败');
					} else {
						alert('删除到回收站');
						window.location.reload();
					}
				}
			});
		}
	</script>

	<span><c:if test="${not empty msg }">
			<script type="text/javascript">
				alert("${msg}");
			</script>
		</c:if></span>
	<div class="content">

		<div class="header">

			<h1 class="page-title">Admins</h1>
	</div>

		<ul class="breadcrumb">
			<li><a href="#">Home</a> <span class="divider">/</span></li>
			<li class="active">Users</li>
	</ul>
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
								<th>名称</th>
								<th>密码</th>
								<th style="width: 26px;"></th>
						</tr>
					</thead>
						<c:forEach items="${aList}" var="ad" varStatus="status">
							<tbody>

								<tr id="tr_${ad.id}">
									<td>${(pageNo-1)*pageSize+status.count}</td>
									<td>${ad.admin_name}</td>
									<td>${ad.admin_password}</td>
									<td>
									 <a
										href='<c:url value="/modifyAdmin?admin.id=${ad.id }"></c:url>'><i
											class="icon-pencil"></i></a>  <%--  <a
										href="<c:url value="/recycleBinAdmin?admin.id=${ad.id }&admin.status=0"></c:url>"><i
											class="icon-remove"></i></a> --%> <a
										onclick="deleteAdmin('${ad.id}');" href="javascript:void(0);">
											<i class="icon-remove"></i>
									</a>
								</td>
							</tr>

							</tbody>
						</c:forEach>
				</table> <i class="icon-plus"></i> <a
					href='<s:url action="createAdmin"></s:url>'>添加</a>
			</div>
				<div class="pagination">
					<ul>
						<li><a>共有${count }条记录，当前第${pageNo}/${totalPage}页</a></li>
						<li><c:if test="${pageNo!=1 }">
								<a
									href='<s:url action="/listAdmin" >
									<s:param name="pageNo" value="1"/>   
									</s:url>'>首页</a>
							</c:if> <c:if test="${pageNo==1 }">
								<a href="javascript:void(0);" style="color: #cfcfcf">首页</a>
							</c:if></li>
						<li><c:if test="${pageNo!=1 }">

								<a
									href='<s:url action="listAdmin">
									<s:param name="pageNo" value="#request.pageNo-1"/>
									</s:url>'>上一页</a>

							</c:if> <c:if test="${pageNo==1 }">

								<a href="javascript:void(0);" style="color: #cfcfcf;">上一页</a>

							</c:if></li>
						<li><c:if test="${pageNo!=totalPage }">

								<a
									href='<s:url action="listAdmin">
									
									<s:param name="pageNo" value="#request.pageNo+1"/>
									</s:url>'>下一页</a>
							</c:if> <c:if test="${pageNo==totalPage }">
								<a href="javascript:void(0);" style="color: #cfcfcf;">下一页</a>
							</c:if></li>
						<li><c:if test="${pageNo!=totalPage }">
								<a
									href='<s:url action="listAdmin">
									<s:param name="pageNo" value="#request.totalPage"/>
									</s:url>'>尾页</a>
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