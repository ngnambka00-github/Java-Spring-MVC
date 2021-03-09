package com.ngnam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngnam.entity.DanhMucSanPham;
import com.ngnam.entity.GioHang;
import com.ngnam.entity.SanPham;
import com.ngnam.service.DanhMucSanPhamService;
import com.ngnam.service.SanPhamService;

@Controller
@RequestMapping(path="/danhmuc")
public class DanhMucController {

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	public String getDefault(ModelMap modelMap) {
		
		// Load danh sách danh mục lên view
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.layDanhSachDanhMucSanPham();
		modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
		
		return "danhmuc";
	}
	
	@GetMapping(path="/{madanhmuc}/{tendanhmuc}")
	public String loadSanPhamTheoDanhMuc(
		HttpSession httpSession,
		@PathVariable(name="madanhmuc") int maDanhMuc, 
		@PathVariable(name="tendanhmuc") String tenDanhMuc, 
		ModelMap modelMap){
		
		// Load danh sách danh mục lên view
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.layDanhSachDanhMucSanPham();
		modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
		
		
		modelMap.addAttribute("tendanhmuc", tenDanhMuc);
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamTheoDanhMuc(maDanhMuc);
		modelMap.addAttribute("listSanPham", listSanPham);
		
		// Load thống báo số lượng sản phẩm nếu có
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		modelMap.addAttribute("listGioHang", listGioHang);
		return "danhmuc";
	}
}
