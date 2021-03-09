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
	
	<title>Trang chủ Page</title>
</head>
<body>

	<!-- Start div header -->
	<div id="header" class="header">
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
		        				<a class="nav-link" href="#" id="btn-dang-xuat">Đăng xuất</a>
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
		
		<div class="header__event">
			<span>Ngày 14/01 - 25/02/2021</span>
			<h1>Mua 1 - Tặng 1</h1>
			<button class="btn btn-primary">Xem Ngay</button>
		</div>
	</div>
	<!-- End div header -->
	
	<!-- Start div Informaton of Service -->
	<div id="infor-service" class="container">
		<div class="row">
			<div class="col-12 col-sm-12 col-md-4 text-center infor-service--item wow bounceInLeft" data-wow-duration="0.8s">
				<img class="icon-48 infor-service--item__image" alt="" src='<c:url value="/resources/images/infor-service-quality.png"/>'><br>
				<span class="text-center infor-service--item__title">CHẤT LƯỢNG</span><br>
				<span class="text-center infor-service--item__description">Chúng tôi cam kết rằng sẽ đem lại cho bạn chất lượng sản phẩm tốt nhất</span><br>
			</div>
			<div class="col-12 col-sm-12 col-md-4 text-center infor-service--item wow bounceInDown" data-wow-duration="0.8s" data-wow-delay="0.4s">
				<img class="icon-48 infor-service--item__image" alt="" src='<c:url value="/resources/images/infor-service-money.png"/>'><br>
				<span class="text-center infor-service--item__title">TIẾT KIỆM CHI PHÍ</span><br>
				<span class="text-center infor-service--item__description">Cam kết rẻ nhất Việt Nam. Giúp các bạn tiết kiệm 20% cho từng sản phẩm</span><br>
			</div>
			<div class="col-12 col-sm-12 col-md-4 text-center infor-service--item wow bounceInRight" data-wow-duration="0.8s" data-wow-delay="0.8s">
				<img class="icon-48 infor-service--item__image" alt="" src='<c:url value="/resources/images/infor-service-delivery-truck.png"/>'><br>
				<span class="text-center infor-service--item__title">GIAO HÀNG</span><br>
				<span class="text-center infor-service--item__description">Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến khách hàng nhanh nhất</span><br>
			</div>
		</div>
	</div>
	<!-- End div Informaton of Service -->
	
	<!-- Start div load danh sách các sản phẩm -->
	<div id="view-product" class="container">
		<div class="row view-product--title">
			<span>Sản phẩm hot</span>
		</div>
		<div class="row">
			<c:forEach var="sanPham" items="${ listSanPham }">
				<a alt="" href="chitiet/${ sanPham.getMaSanPham() }" class="col-sm-6 col-md-3 wow fadeInDown" data-wow-duration="0.6s">
					<div class="card view-product--item">
						<img class="card-img-top" src='<c:url value="/resources/images/sanpham/${ sanPham.getHinhSanPham() }"/>' alt="Card image cap">
					  	<div class="card-body">
					    	<h5 class="card-title view-product--item__title">${ sanPham.getTenSanPham() }</h5>
					    	<p class="card-text view-product--item__price">${ sanPham.getGiaTien() } VNĐ</p>
					  	</div>
					</div>
				</a>	
			</c:forEach>
		</div>
	</div>
	<!-- End div load danh sách các sản phẩm -->
	
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

