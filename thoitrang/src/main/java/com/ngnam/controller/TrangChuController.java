package com.ngnam.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ngnam.dao.DanhMucSanPhamDAO;
import com.ngnam.entity.DanhMucSanPham;
import com.ngnam.entity.GioHang;
import com.ngnam.entity.SanPham;
import com.ngnam.service.DanhMucSanPhamService;
import com.ngnam.service.SanPhamService;


@Controller
@RequestMapping("/")
@SessionAttributes(names= {"giohang", "email"})
public class TrangChuController {
	
	@Autowired 
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	// @Transactional chỉ áp dụng cho class nào có thực hiện truy vấn, query Database
	@GetMapping
	public String Default(HttpSession session, ModelMap modelMap, HttpSession httpSession) {
		if (session.getAttribute("email") != null) {
			String email = (String)session.getAttribute("email");
			String chuCaiDau = email.substring(0, 1);
			modelMap.addAttribute("chuCaiDau", chuCaiDau);
			session.setMaxInactiveInterval(10);
		} 
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPham(0, 12);
		modelMap.addAttribute("listSanPham", listSanPham);
		
		// Load thống báo số lượng sản phẩm nếu có
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		modelMap.addAttribute("listGioHang", listGioHang);
		
		// Load danh mục sản phẩm ở phần header
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.layDanhSachDanhMucSanPham();
		modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
		return "trangchu";
	}
	
	@PostMapping
	public String themNhanVien(@RequestParam String tenNhanVien, @RequestParam int tuoi) {
		return "trangchu";
	}
	
	@GetMapping(path="/finish") 
	public String getLogout(HttpSession session) {
		if (session.getAttribute("email") != null) {
			session.removeAttribute("email");
		}
		return "redirect:/";
	}
}
