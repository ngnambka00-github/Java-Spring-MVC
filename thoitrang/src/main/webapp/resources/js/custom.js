
$(document).ready(() => {
	$('#btn-dang-nhap').click(() => {
		var inputUser = $("#username").val();
		var inputPass = $("#password").val();
		$.ajax({
			url: "/thoitrang/api/KiemTraDangNhap", 
			type: "GET",
			// truyền tham số với hàm xử lý thông qua data
			data: {
				tenDangNhap: inputUser, 
				matKhau: inputPass
			}, 
			success: (value) => {
				if (value == "user_ko_ton_tai") {
					$("#kiem-tra-dang-nhap-loi").text("User không tồn tại !");
					
					// Set focus cho tenDangNhap để có nhập lại
					$("#username").focus();
				} else if (value == "sai_mat_khau"){
					$("#kiem-tra-dang-nhap-loi").text("Sai mật khẩu đăng nhập!");
					
					// set focus cho matKhau để có thể nhập lại
					$("#password").focus();
				} else if (value == "thanh_cong"){
					var duongDanHienTai = window.location.href;
					var duongDan = duongDanHienTai.replace("/dangnhap/", "");
					window.location = duongDan;
				}
			}
		});
	});
	
	$("#btn-dang-xuat").click(() => {
		window.location.href = "/thoitrang/finish";
	});
	
	// Khai báo các biến 
	var spanLogin = $("#span-login");
	var spanRegister = $("#span-register");
	var formLogin = $("#container-login-right .form-login");
	var formRegister = $("#container-login-right .form-register");
	var labelErrorLogin = $("#kiem-tra-dang-nhap-loi")
	
	spanLogin.click(function() {
		spanLogin.addClass("actived");
		spanRegister.removeClass("actived");
		formLogin.removeClass("display-none");
		formRegister.addClass("display-none");
		labelErrorLogin.text("");
		$("#username").focus();
	});
	
	spanRegister.click(function() { 
		spanRegister.addClass("actived");
		spanLogin.removeClass("actived");
		formLogin.addClass("display-none");
		formRegister.removeClass("display-none");
		labelErrorLogin.text("");
		$("#register-username").focus();
	});
	
	
	$(".btn-them-gio-hang").click(function() {
		let maChiTietSanPham = parseInt($(this).data("maChiTietSanPham"));
		
		let parent = $(this).closest('tr');
		
		let maSanPham = parseInt($('.ten-san-pham').data('maSanPham'));
		let maMau = parseInt(parent.find('.mau-san-pham-chi-tiet').data('mau'));
		let maSize = parseInt(parent.find('.size-san-pham-chi-tiet').data('size'));
		
		let tenSanPham = $('.ten-san-pham').text();
		let tenMau = parent.find('.mau-san-pham-chi-tiet').text();
		let tenSize = parent.find('.size-san-pham-chi-tiet').text();
		let hinhSanPham = $('.image-san-pham').data('nameImage');
		
		let giaTien = $('.gia-san-pham').data('giaTien');
		let soLuong = parseInt(parent.find('.so-luong-san-pham-chi-tiet').data('soLuong'));
		
		$.ajax({
			url: '/thoitrang/api/ThemGioHang',
			type: 'GET', 
			data: {
				maChiTietSanPham,
				maSanPham, maMau, maSize, 
				tenSanPham, tenMau, tenSize, hinhSanPham,
				giaTien, soLuong
			}, 
			success: function(value) {
				let icon = $('.icon-shopping-cart').find('span');
				icon.html(value);
				icon.removeClass('d-none');
			}
 		});
		
	});
	
	// format dữ liệu number: Ví dụ: 123456760 -> 123.456.760
	function formatNumber(num) {
		let numString = String(num);
		let sodu = numString.length % 3;
		let sothuc = Math.floor(numString.length / 3);
		
		let arr = [numString.slice(0, sodu)];
		
		for (let i = 0; i < sothuc; i++) {
			arr.push(numString.slice(sodu + 3 * i, sodu + 3 + 3 * i));
		}
		
		if (sodu === 0)
		  arr = arr.slice(1);

		return arr.join('.');
	}
	
	// Load tổng tiền sản phẩm của page giỏ hàng: 
	function loadTongTienThanhToan() {
		let sum = 0;
		$('.row-gio-hang').each(function() {
			let soLuong = parseInt($(this).find("input[type='number']").val());
			let giaTienGoc = parseInt($(this).find(".gia-goc-san-pham-gio-hang").data("giaTienGoc").split('.').join(''));
			let giaTien = soLuong * giaTienGoc;
			sum = sum + giaTien;
			
			// Cập nhập lại dữ liệu giá tiền tổng theo từng hàng
			$(this).find(".gia-tien-san-pham-gio-hang").text(formatNumber(giaTien) + " VNĐ");
		})
		
		// Cập nhập lại tổng tiền
		$('.tong-tien-thanh-toan').text(formatNumber(sum) + " VNĐ");
	}
	// Thực thi cập nhập tổng tiền trong lần chạy đầu tiên: 
	loadTongTienThanhToan();
	
	// Sự kiện change khi thay đổi số lượng trong giỏ hàng
	$(".input-thay-doi-so-luong").change(function() {
		let soLuong = parseInt($(this).closest("tr").find("input[type='number']").val());
		let giaTienGocString = $(this).closest("tr").find(".gia-goc-san-pham-gio-hang").data("giaTienGoc");
		let giaTienGoc = parseInt(giaTienGocString.split('.').join(''));
		let tongTien = soLuong * giaTienGoc;
		
		// Cập nhập dữ liệu tổng thanh toán
		loadTongTienThanhToan();
		
		// Cập nhập lại dữ liệu vào database thông qua ajax
		let maSanPham = parseInt($(this).closest("tr").data("maSanPham"));
		let maMauSanPham = parseInt($(this).closest("tr").find(".mau-san-pham-gio-hang").data("maMau"));
		let maSizeSanPham = parseInt($(this).closest("tr").find(".size-san-pham-gio-hang").data("maSize"));
		$.ajax({
			url: "/thoitrang/api/UpdateSoLuongGioHang", 
			type: "GET", 
			data: { 
				soLuong, 
				maSanPham, 
				maMauSanPham, 
				maSizeSanPham
			}
		});
	});
	
	$(".btn-xoa-san-pham-gio-hang").click(function() {
		let parent = $(this).closest("tr");
		
		// Xóa trên giao diện
		parent.remove();
		
		// Lấy dữ liệu để đưa vào api ajax 
		let maSanPham = parseInt($(this).closest("tr").data("maSanPham"));
		let maMauSanPham = parseInt($(this).closest("tr").find(".mau-san-pham-gio-hang").data("maMau"));
		let maSizeSanPham = parseInt($(this).closest("tr").find(".size-san-pham-gio-hang").data("maSize"));
		
		// Cập nhập lại dữ liệu trên session
		$.ajax({
			url: "/thoitrang/api/XoaSanPhamGioHang", 
			type: "GET", 
			data: {
				maSanPham, 
				maMauSanPham, 
				maSizeSanPham
			}
		});
		
		// Loại lại giá tiền
		loadTongTienThanhToan();
		
		// Update lại số lượng trên icon giỏ hàng phần header
		let iconSoLuong = $(".icon-shopping-cart").find('span')
		let soLuongHienTai = parseInt(iconSoLuong.text()) - 1;
		if (soLuongHienTai == 0) {
			iconSoLuong.addClass('d-none');
		}
		iconSoLuong.text(String(soLuongHienTai));
	});
	
	$('.pagination-item-sanpham').click(function() {
		let pageNumber = parseInt($(this).data('pageNumber'));
	
		$.ajax({
			url: '/thoitrang/api/PhanTrangSanPham',
			type: 'GET', 
			data: {
				pagenumber: pageNumber
			}, 
			success: function(value) {
				let object = JSON.parse(value);	
				let content = '';
				for (var item of object) {
					content += `<tr>
							<td>
								<div class="form-check w-100 h-100 align-middle text-center">
									<input type="checkbox" class="form-check-input"/>
								</div>
							</td>
							<td class="align-middle">
								<img src="/thoitrang/resources/images/sanpham/${item.hinhAnh}" width="50px">
							</td>
							<td class="align-middle">${item.tenSanPham}</td>
							<td class="align-middle">${item.giaTien} VNĐ</td>
							<td class="align-middle">${item.gianhCho}</td>
						</tr>`;
				}
				$("#content-them-san-pham").html(content);
			}
		});
	});
	
});



