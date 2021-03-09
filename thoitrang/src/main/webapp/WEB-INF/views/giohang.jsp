<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Thêm thự viện jstl vào file .jsp -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<jsp:include page="header.jsp"/>
	
	<!-- Load thư viện icon -->
	
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
	<title>Trang chủ Page</title>
</head>
<body>

	<!-- Start div header -->
	<div id="header" class="header header--chitiet--page">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand ms-4" href="#">
				<div class="header__box__icon"> 
					<img src="<c:url value="/resources/images/icon-logo.png"/>" alt=""/>
				</div>
			</a>
		  	<button class="navbar-toggler border-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		
		  	<div class="collapse navbar-collapse nav-collapse-custom" id="navbarSupportedContent">
		    	<ul class="navbar-nav m-auto">
		      		<li class="nav-item active">
		        		<a class="nav-link" href="/thoitrang">TRANG CHỦ</a>
		      		</li>
		      		<li class="nav-item dropdown">
			        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			          		SẢN PHẨM
			        	</a>
			        	<ul class="dropdown-menu  bg-dark border-0 dropdown-custom" aria-labelledby="navbarDropdown">
			        		<c:forEach var="value" items="${ listDanhMuc }">			        		
				            	<li><a class="dropdown-item" href='<c:url value="/danhmuc/${ value.getMaDanhMuc() }/${ value.getTenDanhMuc() }"/>'>${ value.getTenDanhMuc() }</a></li>
				            	<li><hr class="dropdown-divider border-white"></li>
			        		</c:forEach>
			          	</ul>
			      	</li>
		      		
		      		<li class="nav-item">
		        		<a class="nav-link" href="#">DỊCH VỤ</a>
		      		</li>
		      		<li class="nav-item">
		        		<a class="nav-link" href="#">LIÊN HỆ</a>
		      		</li>
		    	</ul>
		    	<ul class="navbar-nav">
		    		<c:choose>
		    			<c:when test="${ chuCaiDau != null }">
				      		<li class="nav-item active">
				        		<a class="nav-link" id="icon-user" href="#">${ chuCaiDau }</a>
				      		</li>	
				      		<li class="nav-item active">
		        				<a class="Chúngnav-link" href="#" id="btn-dang-xuat">Đăng xuất</a>
		      				</li>	    			
		    			</c:when>
		    			
		    			<c:otherwise>
		    				<li class="nav-item active">
		        				<a class="nav-link" href="/thoitrang/dangnhap/">Đăng nhập</a>
		      				</li>
		    			</c:otherwise>
		    		</c:choose>
		      		
		      		<li class="nav-item me-3">
		        		<a class="nav-link" href="/thoitrang/giohang">
		        			<span class="fas fa-shopping-cart cart position-relative d-block icon-shopping-cart">
			        			<span class="badge rounded-pill bg-danger position-absolute top-0 start-100 translate-middle small <c:if test="${listGioHang == null || listGioHang.size() == 0}">d-none</c:if>">${ listGioHang.size() }</span>		        					
		        			</span>
		        		</a>
		      		</li>
		    	</ul>
		  	</div>
		</nav>
	<!-- End div header -->
	

	<!-- Bắt đầu phần page giỏ hàng -->
	<div id="giohang" class="container mt-4">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-decoration-underline">Thông tin giỏ hàng</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th class="align-middle">Tên sản phẩm</th>
							<th class="align-middle">Màu sản phẩm</th>
							<th class="align-middle">Size</th>
							<th class="align-middle">Số lượng</th>
							<th class="align-middle">Giá gốc</th>
							<th class="align-middle">Thành tiền</th>
							<th class="align-middle">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="value" items="${ listGioHang }">
							<tr class="row-gio-hang" data-ma-san-pham="${ value.getMaSanPham() }" data-ma-chi-tiet-san-pham="${ value.getMaChiTietSanPham() }">
								<td class="text-center align-middle">
									<img alt="" src="<c:url value="/resources/images/sanpham/${ value.getHinhSanPham() }"/>" width="50px">
								</td>
								<td class="ten-san-pham-gio-hang align-middle" data-ten-san-pham="${ value.getTenSanPham() }">${ value.getTenSanPham() }</td>
								<td class="mau-san-pham-gio-hang align-middle" data-mau="${ value.getTenMau() }" data-ma-mau="${ value.getMaMau() }">${ value.getTenMau() }</td>
								<td class="size-san-pham-gio-hang align-middle" data-size="${ value.getTenSize() }" data-ma-size="${ value.getMaSize() }">${ value.getTenSize() }</td>
								<td class="so-luong-san-pham-gio-hang align-middle" data-so-luong="${ value.getSoLuong() }">
									<input type="number" value="${ value.getSoLuong() }" class="form-control input-thay-doi-so-luong" min="1"/>
								</td>
								<td class="gia-goc-san-pham-gio-hang align-middle" data-gia-tien-goc="${ value.getGiaTien() }">${ value.getGiaTien() } VNĐ</td>
								<td class="gia-tien-san-pham-gio-hang align-middle"></td>
								<td class="align-middle">
									<button class="btn btn-close btn-xoa-san-pham-gio-hang"></button>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td> </td>
							<td colspan="4"><h5>Tổng tiền</h5></td>
							<td colspan="3" class="text-center"><h5 class="text-danger tong-tien-thanh-toan">20403232 VND</h5></td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div>
			
		<div class="row mt-4">
			<div class="col-md-6">
				<h3 class="text-decoration-underline">Thông tin người nhận/mua</h3>
				<form action="" method="POST" class="d-grid gap-3">
					<div class="form-group">
						<label for="tennguoinhan" class="form-label">Tên người mua/nhận</label>
						<input type="text" id="tennguoinhan" placeholder="Họ và tên" class="form-control" name="tenkhachhang">
					</div>
					
					<div class="form-group">
						<label for="dienthoailienlac" class="form-label">Điện thoại liên lạc</label>
						<input type="text" id="dienthoailienlac" placeholder="Điện thoại liên lạc" class="form-control" name="sodienthoai">
					</div>
					
					<div class="luachongiaohang">					
						<div class="form-check">
							<input type="radio" class="form-check-input" id="giaohangtannoi" checked name="hinhthucgiaohang" value="Giao hàng tận nơi"/>
							<label for="giaohangtannoi" class="form-check-label">Giao hàng tận nơi</label>
						</div>
						<div class="form-check">
							<input type="radio" class="form-check-input" id="nhanhangtaicuahang" name="hinhthucgiaohang" value="Nhận hàng tại cửa hàng"/>
							<label for="nhanhangtaicuahang" class="form-check-label">Nhận hàng tại cửa hàng</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="diachigiaohang" class="form-label">Địa chỉ giao hàng</label>
						<input type="text" id="diachigiaohang" placeholder="Địa chỉ giao hàng" class="form-control"/ name="diachigiaohang">
					</div>
					
					<div class="form-group">
						<label for="ghichu" class="form-label">Ghi chú</label>
						<textarea id="ghichu" placeholder="Nội dung ghi chú" class="form-control" name="ghichu">
						</textarea>
					</div>
					
					<div >					
						<input type="submit" class="btn btn-primary" value="Đặt hàng"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Kết thúc phần page giỏ hàng -->
	
	<!-- Start div cho phần footer -->
	<div id="contact-footer" class="container-fluid">
		<div class="row">
			<div  class="col-sm-12 col-md-4 contact-footer--item wow bounce" data-wow-duration="1s">
				<p class="contact-footer--item__title text-md-center text-left text-uppercase"><span>Thông tin shop</span></p>
				<p>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</p>
			</div>
			
			<div  class="col-sm-12 col-md-4 contact-footer--item wow bounce" data-wow-duration="1s">
				<p class="contact-footer--item__title text-md-center text-left text-uppercase"><span>Liên hệ</span></p>
				<p class="contact-footer--item__infor">Địa chỉ: Số 93, ngõ 41 đường Hoàng Mai, quận Hai Bà Trưng, Hà Nội</p>
				<p class="contact-footer--item__infor">Email: ngnambka00@gmail.com</p>
				<p class="contact-footer--item__infor">SĐT: 0901599299</p>
			</div>
			
			<div  class="col-sm-12 col-md-4 contact-footer--item wow bounce" data-wow-duration="1s">
				<p class="contact-footer--item__title text-md-center text-left text-uppercase"><span>Góp ý</span></p>
				<form action="" method="POST">
					<div class="d-grid gap-2">					
						<div class="form-group">					
							<input type="text" placeholder="Email" class="form-control" name="tenNhanVien"/>
						</div>
						
						<div class="form-group">					
							<textarea class="form-control" placeholder="Nội dung" name="tuoi"></textarea>
						</div>
						<button type="submit" class="btn btn-block btn-primary">Đồng ý</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>

