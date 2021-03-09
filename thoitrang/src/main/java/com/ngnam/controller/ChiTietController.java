package com.ngnam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ngnam.entity.DanhMucSanPham;
import com.ngnam.entity.GioHang;
import com.ngnam.entity.SanPham;
import com.ngnam.service.DanhMucSanPhamService;
import com.ngnam.service.SanPhamService;

@Controller
@RequestMapping(path="/chitiet")
@SessionAttributes(names= {"giohang"})
public class ChiTietController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@GetMapping(path="/{masanpham}") 
	public String getDefault(
		@PathVariable(name="masanpham") int maSanPham, 
		ModelMap modelMap, HttpSession httpSession) {
		// Load icon user trên header
		if (httpSession.getAttribute("email") != null) {
			String email = (String)httpSession.getAttribute("email");
			String chuCaiDau = email.substring(0, 1);
			modelMap.addAttribute("chuCaiDau", chuCaiDau);
			httpSession.setMaxInactiveInterval(10);
		}
		
		// Gửi dữ liệu danh mục sản phẩm
		List<DanhMucSanPham> danhMucSanPham = danhMucSanPhamService.layDanhSachDanhMucSanPham();
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		
		// Gửi thông tin sản phẩm sang page ChiTiet.jsp
		SanPham sanPham = sanPhamService.laySanPhamTheoMa(maSanPham);
		modelMap.addAttribute("sanPham", sanPham);
		
		// Load số lượng giỏ hàng nếu có
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		modelMap.addAttribute("listGioHang", listGioHang);

		return "chitiet";
	}
}
