<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Import thư viện của JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="header.jsp"/>
		<title>Đăng nhập Page</title>
	</head>
<body>
	<div id="body-login">
		<div id="body-flex-login">
			<div id="container-login">
				<div id="container-login-left">
					<div class="content">
						<div class="header-login">
							<span>Wellcome</span>
							<br>
							<span>Hãy tạo lên phong cách của bạn cùng MiniShop</span>
						</div>
						
						<div class="footer-login">
							<p>
								<img alt="" src='<c:url value="/resources/images/Icon_oval.png"/>'>
								<span>Luôn cập nhập du thế lớn nhất</span>
							</p>
							
							<p>
								<img alt="" src='<c:url value="/resources/images/Icon_oval.png"/>'>
								<span>Giảm hơn 50% các mặt hàng dành cho khách VIP</span>
							</p>
							<p>
								<img alt="" src='<c:url value="/resources/images/Icon_oval.png"/>'>
								<span>Tự tin tư vấn tạo nên phong cách của bạn</span>
							</p>
						</div>
					</div>
				</div>
				
				<div id="container-login-right">
					<c:if test="${ trangThaiLoiDangKy == null }">
						<c:set var="trangThaiLoiDangKy" value="false"/>
					</c:if>
					
					<div class="header-top-right">
						<span id="span-login" class="<c:if test="${ trangThaiLoiDangKy eq false }">actived</c:if>">Đăng nhập</span> /
						<span id="span-register" class="<c:if test="${ trangThaiLoiDangKy eq true }">actived</c:if>">Đăng ký</span>
					</div>
					
					<div>
						<div class="form-middle form-login <c:if test='${ trangThaiLoiDangKy eq true}'>display-none</c:if>">
							<input id="username" value="${ tenDangNhap }" type="text" name="login-username" class="text-input input-icon-email" placeholder="Username" autofocus>
							<input id="password" value="${ matKhau }" type="password" name="login-password" class="text-input input-icon-password" placeholder="Password">
							<span id="btn-dang-nhap">Đăng nhập</span><br>
						</div>
						<div class="form-middle form-register <c:if test='${ trangThaiLoiDangKy != true}'>display-none</c:if>">	
							<form action="/thoitrang/dangnhap" method="POST">
								<input id="register-username" value="${ register_username }" type="text" name="register-username" class="text-input input-icon-email" placeholder="Username">
								<input id="register-password" value="${ register_password }" type="password" name="register-password" class="text-input input-icon-password" placeholder="Password">
								<input id="register-repassword" value="${ register_repassword }" type="password" name="register-repassword" class="text-input input-icon-password" placeholder="Repassword">
								<input id="btn-dang-ky" type="submit" value="Đăng ký"/><br>
							</form>				
						</div>
						<span id="kiem-tra-dang-nhap-loi">${ thongTinLoi }</span><br>
					</div>
					
					<div class="icon-bottom">
						<img alt="facebook" src='<c:url value="/resources/images/logo-fb.png"/>'>
						<img alt="google" src='<c:url value="/resources/images/logo-gg.png"/>'>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>