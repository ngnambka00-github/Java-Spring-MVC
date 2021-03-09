package com.ngnam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngnam.dao.ChiTietHoaDonDAO;
import com.ngnam.entity.ChiTietHoaDon;
import com.ngnam.entity.ChiTietHoaDonId;
import com.ngnam.entity.DanhMucSanPham;
import com.ngnam.entity.GioHang;
import com.ngnam.entity.HoaDon;
import com.ngnam.service.ChiTietHoaDonService;
import com.ngnam.service.DanhMucSanPhamService;
import com.ngnam.service.HoaDonService;

@Controller
@RequestMapping(path="/giohang")
public class GioHangController {
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@GetMapping
	public String getDefault(HttpSession httpSession, ModelMap modelMap) {
		
		// Load số lượng giỏ hàng nếu có
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		modelMap.addAttribute("listGioHang", listGioHang);
		
		
		// Load danh sách danh mục sản phẩm lên view
		List<DanhMucSanPham> listDanhMucSanPham = (List<DanhMucSanPham>)danhMucSanPhamService.layDanhSachDanhMucSanPham();
		modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
		return "giohang";
	}
	
	@PostMapping 
	public String themHoaDon(
		HttpSession httpSession,
		@RequestParam(name="tenkhachhang") String tenKhachHang, 
		@RequestParam(name="sodienthoai") String soDienThoai, 
		@RequestParam(name="diachigiaohang") String diaChiGiaoHang, 
		@RequestParam(name="hinhthucgiaohang") String hinhThucGiaoHang, 
		@RequestParam(name="ghichu") String ghiChu) {
		
		if (httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
			
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenKhachHang(tenKhachHang);
			hoaDon.setSoDienThoai(soDienThoai);
			hoaDon.setDiaChiGiaoHang(diaChiGiaoHang);
			hoaDon.setHinhThucGiaoHang(hinhThucGiaoHang);
			hoaDon.setGhiChu(ghiChu);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			hoaDon.setNgayLap(dateFormat.format(new Date()));
			
			// Thực hiện thêm hóa đơn
			boolean checkThemHoaDon = hoaDonService.themHoaDon(hoaDon);
			
			for (GioHang gioHang : listGioHang) {				
				ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
				chiTietHoaDonId.setMaChiTietSanPham(gioHang.getMaChiTietSanPham());
				chiTietHoaDonId.setMaHoaDon(hoaDon.getMaHoaDon());
				
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
				chiTietHoaDon.setGiaTien(gioHang.getGiaTien());
				chiTietHoaDon.setSoLuong(gioHang.getSoLuong());
				
				boolean checkThemChiTietHoaDon = chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDon);
			}
		}
		
		// sau khi đặt hàng xong thì đã xóa giỏ hàng
		httpSession.removeAttribute("giohang");
		return "giohang";
	}
}
