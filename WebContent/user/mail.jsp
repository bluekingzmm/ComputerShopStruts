<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<script type="text/javascript" src="inputmail.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="jquery-1.4.4.min.js"></script>

<script type="text/javascript" src="js/megamenu.js"></script>


<style type="text/css">
.login .on_changes {
	width: 232px;
	position: absolute;
	top: 40px;
	list-style: none;
	background: #FFF;
	border: 1px solid #000;
	display: none;
	padding: 10px;
}

.login .on_changes li {
	margin: 8px;
	padding: 4px;
}

.login .on_changes li.active {
	background: #CEE7FF;
}

.login {
	margin: 0 auto;
	position: relative;
}
</style>

</head>
<%@include file="/nav/basion.jsp"%>
<body>
	<div class="login">
		<div class="wrap">
			<div class="col_1_of_login span_1_of_login">
				<h4 class="title">注册需知</h4>
				<p>在您开始注册之前，请先阅读以下条款： 一、遵守中华人民共和国法律法令和其他相关法规，不可发布破坏宪法和法律、法规的信息。

					二、遵守公安部关于《计算机信息网络国际联网安全保护管理办法》的规定，自觉维护计算机信息网络的安全。

					三、不得在网上宣扬封建迷信、淫秽、色情、暴力、赌博等不正当行为。

					四、企业或个人发布的信息要真实有效、准确完整，并不得有引人误解或者虚假的陈述。 五、申请人必须填写详细、真实信息，如真实姓名 /
					地址、电话等。因信息填写不真实、不完整或填写错误的本网站不予以发表。

					六、本网站建站宗旨是为电脑行业供需双方搭建购物平台。网站所发布的信息是供上网人员参考。因此，供需双方应对交易行为自行负责。

					七、用户注册成功后，请妥善保管您的用户名和密码，以备下次发布、修改信息使用。</p>
				<div class="button1"><a
					href="<c:url value="/user/register.jsp"/>"><input type="submit"
						name="Submit" value="创建新用户"></a></div>
				<div class="clear"></div>
		</div>
			<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
					<h4 class="title">帐号激活</h4>
					<div id="loginbox" class="loginbox">
						<form action='<c:url value="/mailUser"></c:url>' method="post"
						 id="login-form">

							<fieldset class="input">

								<p id="login-form-username"><label for="modlgn_username">用户名</label>
									<input id="modlgn_username" type="text" name="user.user_name"
									class="inputbox" size="18" autocomplete="off"></p>

								<p id="login-form-username"><label for="modlgn_username">邮箱</label><br>
									<input type="text" class="inputbox" autocomplete="off" required
									name="user.mail" placeholder="邮箱" /></p> <br> <input
								type="submit" value="激活"
								class="button button-glow button-border button-rounded button-primary">
								<span style="color: red;">${msg}</span>

						</fieldset>
					</form>
				</div>
			</div>
		</div>
			<div class="clear"></div>
	</div>
</div>

	<div class="footer-top">
		<div class="wrap">
			<div class="section group example">
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
						<li><img src='<c:url value="/images/2.png"></c:url>'><span
							class="f-text">圆通包邮</span>
							<div class="clear"></div></li>
				</ul>
			</div>
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
						<li><img src="<c:url value="/images/3.png"></c:url>"><span
							class="f-text">联系我们 222-555-6666 </span>
							<div class="clear"></div></li>
				</ul>
			</div>
				<div class="clear"></div>
		</div>
	</div>
</div>


	<div class="footer-bottom">
		<div class="wrap">
			<center><a href="<c:url value="/admin/login.jsp"/>"
				style="color: white;">web后台管理登录</a></center>
			<div class="clear"></div>
	</div>
</div>

	<div style="display: none"></div>

</body>
</html>