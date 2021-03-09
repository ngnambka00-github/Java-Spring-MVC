package com.ngnam.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ngnam.entity.NhanVien;
import com.ngnam.service.NhanVienService;

@Controller
@RequestMapping(path="/dangnhap")
public class DangNhapController {
	
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default() {
		return "dangnhap"; // dangnhap.jsp

	}
	
	@PostMapping
	public String dangKy(
		HttpSession session,
		@RequestParam(value="register-username") String tenDangNhap, 
		@RequestParam(value="register-password") String matKhau, 
		@RequestParam(value="register-repassword") String nhapLaiMatKhau,
		ModelMap modelMap) {

		boolean checkMail = kiemTraEmailHopLe(tenDangNhap);

		// Gửi dữ liệu đề fill -> Nếu trường hợp xảy ra lỗi
		modelMap.addAttribute("register_username", tenDangNhap);
		modelMap.addAttribute("register_password", matKhau);
		modelMap.addAttribute("register_repassword", nhapLaiMatKhau);
		
		String labelError = "";
		boolean checkError = false;
		
		// Trường hợp email hợp lệ
		if (checkMail && matKhau.equals(nhapLaiMatKhau)) {
			NhanVien nhanVien = new NhanVien();
			
			// Cho email và tenDangNhap giong nhau
			nhanVien.setTenDangNhap(tenDangNhap);
			nhanVien.setEmail(tenDangNhap);
			nhanVien.setMatKhau(matKhau);
			boolean checkThemNhanVien = nhanVienService.themNhanVien(nhanVien);
			if (!checkThemNhanVien) {
				labelError = "Thêm không thành công";	
				checkError = true;
			}
		} else if (checkMail && !matKhau.equals(nhapLaiMatKhau)){
			labelError = "Vui lòng điền khớp mật khẩu";
			checkError = true;
		} else {
			labelError = "Vui lòng nhập đúng Email";
			checkError = true;
		}
		
		if (checkError) {
			modelMap.addAttribute("thongTinLoi", labelError);
			modelMap.addAttribute("trangThaiLoiDangKy", checkError);
			return "dangnhap";
		}
		// Nếu đăng ký thành công thì thêm dữ liệu vào session và chuyển về page trangChu 
		session.setAttribute("email", tenDangNhap);
		session.setMaxInactiveInterval(20);
		
		return "redirect:/";
	}
	
	public boolean kiemTraEmailHopLe(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern
			    .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
			    			Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
}
