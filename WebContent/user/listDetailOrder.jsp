<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单明细</title>

</head>
<body>
<%-- 
	<div class="modal-header">
		<h4 id="myModalLabel">订单详情</h4>
</div>

	<span>订单编号:${od.orderId} &nbsp; &nbsp;总价:￥${od.totalPrice}&nbsp;
		订单日期:${od.submitTime}</span>


	<table class="table table-hover table-bordered ">
		<tr>
			<th width="60" align="left">序号</th>
			<th width="60" align="left">图片</th>
			<th width="100" align="left">品牌</th>
			<th width="100" align="left">型号</th>
			<th width="60" align="left">数量</th>
			<th width="100" align="left">合计</th>
	</tr>

		<c:forEach items="${ol}" var="ol" varStatus="index">
			<tr>
				<td>${index.count}</td>

				<td><img id="photo" width="34" height="34"
					src="<c:if test="${!empty ol.com.imgPath }">
													<c:url value="/upload/${ol.com.imgPath}"></c:url>
												</c:if>
												<c:if test="${empty ol.com.imgPath }">
												images/default.jpg
												</c:if>"></td>

				<td>${ol.com.brand.brand_name}</td>
				<td>${ol.com.model}</td>
				<td>${ol.account}</td>
				<td>￥${ol.account * ol.buy_price}</td>
			</tr>
		</c:forEach>


</table> --%>
	<c:forEach var="o" items="${o}">
		<c:if test="${o.isPay==1 }">
			<c:if test="${o.isDeliver==0 }">
				<c:if test="${o.tx==0 }">
					<form
						action="<c:url value="/updateServiceOrder?order.orderId=${o.orderId }&order.tx=1&order.status=1"/>"
						method="post">
						<input type="text" name="order.label"
						placeholder="备注" value="空"> <input class="btn btn-primary"
						type="submit" value="提醒发货"></form>
				</c:if>
				<c:if test="${o.tx==1 }">
					<a href='javascript:void(0)' style="color: #cfcfcf">请等待</a>
				</c:if>
			</c:if>

		</c:if>

	</c:forEach>

</body>
</html>