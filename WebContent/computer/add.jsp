<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/lib/bootstrap/css/bootstrap.css"/>">

<link rel="stylesheet" type="text/css" href="<c:url value="/stylesheets/theme.css"/>">
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
<script src="<c:url value="/lib/jquery-1.7.2.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/js/jquery-1.6.1.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/jquery.upload.js"/>" type="text/javascript"></script>
<script type="text/javascript">
function doUpload() {
	$.upload({
	url:"<c:url value="/uploadAction"/>",
	fileName:"image",
	dataType:'json',
	onSend:function(){
		return true;
	},
	onComplate:function(data){
		$("#uploads").html(
			$("<img/>").attr("src",data.url).attr("width",200)
			
		);
		$("#imgPath").val(data.name);		
		
	}
	});
}

$(document).ready(function(){
	$.ajax({
		type:"POST",
		url:"<s:url value="/allListComputer"/>",
		dataType:'json',
		success: function(data){
		$.each(data.bList ,function(i,o){
			$("#brand").append("<option value='"+o.brand_id+"'>"+o.brand_name+"</option>");

			});
		$.each(data.cList ,function(i,o){
			$("#cpu").append("<option value='"+o.cpu_id+"'>"+o.cpu_name+"</option>");

			});	$.each(data.sList ,function(i,o){
			$("#screen").append("<option value='"+o.screen_id+"'>"+o.screen_name+"</option>");

			});
		}
	});
});


</script>
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

fieldset {
	border: none;
	text-align: center;
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

			<h1 class="page-title">Computer</h1>
	</div>

		<ul class="breadcrumb">
			<li><a href="index.html">Home</a> <span class="divider">/</span></li>
			<li class="active">Computer</li>
	</ul>

		<div class="container-fluid">

			<div class="">
				<form method="post"
				action='<c:url value="/addComputer"></c:url>'>
					<table>
						<tr><td>品牌名称</td>
							<td><select name="com.brand.brand_id" id="brand">
									<option value="">==请选择==</option>
									<%-- <c:forEach items="${bList }" var="b">
										<option value="${b.brand_id }">${b.brand_name}</option>
									</c:forEach> --%>
							</select></td></tr>
						<tr><td>电脑型号：</td>
							<td><input type="text" name="com.model" required></td></tr>
						<tr><td>颜色：</td>
							<td><input type="text" name="com.color" required></td></tr>
						<tr><td>价格：</td>
							<td><input type="text" name="com.price" required></td></tr>
						<tr><td>售价：</td>
							<td><input type="text" name="com.rel_price" required></td></tr>
						<tr><td>像素：</td>
							<td><input type="text" name="com.pixels" required></td></tr>
							<tr><td>库存：</td>
							<td><input type="text" name="com.num" required></td></tr>
						<tr><td>处理器：</td>
							<td><select name="com.cpu.cpu_id" id="cpu">
									<option value="">==请选择==</option>
									<%-- <c:forEach items="${cList }" var="c">
										<option value="${c.cpu_id }">${c.cpu_name}</option>
									</c:forEach> --%>
							</select></td></tr>
						<tr><td>屏幕尺寸：</td>
							<td><select name="com.screen.screen_id" id="screen">
									<option value="">==请选择==</option>
									<%-- <c:forEach items="${sList }" var="s">
										<option value="${s.screen_id }">${s.screen_name}</option>
									</c:forEach> --%>
							</select></td></tr>
						<tr><td>内存：</td>
							<td><input type="text" name="com.ram" required></td></tr>
							<tr><td>评价：</td>
							<td><textarea rows="7" cols="7" name="content" required></textarea></td></tr>
						<tr><td>上传图片： <input type="hidden" name="com.imgPath"
								id="imgPath" />
						</td>
							<td><%-- <img id="photo" width="300" height="300"
								src="<c:if test="${!empty imgpath }">
							<c:url value="/upload/${imgpath}"></c:url>
							</c:if> 				
								<c:if test="${empty imgpath}">
							upload/default.jpg							
							</c:if>				
							" /> --%>
							<div id="uploads"></div>
								<a href="#" onclick="upload();">上传</a>
								<input type="button" onclick="doUpload();" value="点击上传">
								</td></tr>
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


	<script src="<c:url value="/lib/bootstrap/js/bootstrap.js"/>"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
	<%-- <script type="text/javascript">
		function upload() {
			window.open('<c:url value='/computer/upload.jsp' />', "",
					"width=450,height=350")
		}
	</script> --%>
</body>
</html>