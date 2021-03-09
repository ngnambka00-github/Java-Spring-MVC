package com.ngnam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngnam.entity.SanPham;
import com.ngnam.service.SanPhamService;

@Controller
@RequestMapping(path="/themsanpham")
public class ThemSanPhamController {

	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	public String getDefault(ModelMap modelMap) {
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPham(0, 5);
		modelMap.addAttribute("listSanPhamLimit", listSanPham);
		
		int tongSoSanPham = sanPhamService.tongSoLuongSanPham();
		modelMap.addAttribute("tongsosanpham", Math.ceil(tongSoSanPham / 5.0));
		
		System.out.println(tongSoSanPham);
		return "themsanpham";
	}
}
