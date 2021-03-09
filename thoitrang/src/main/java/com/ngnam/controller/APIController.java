package com.ngnam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ngnam.entity.DemoJSON;
import com.ngnam.entity.EnumDangNhap;
import com.ngnam.entity.GioHang;
import com.ngnam.entity.SanPham;
import com.ngnam.service.NhanVienService;
import com.ngnam.service.SanPhamService;

@Controller
@RequestMapping(path="/api")
@SessionAttributes(names = { "email", "giohang" })
public class APIController {
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired 
	SanPhamService sanPhamService;
	
	@GetMapping
	@ResponseBody
	public String getDefault() {
		return "default api";
	}
	
	
	@GetMapping(path="/KiemTraDangNhap")
	@ResponseBody
	public String kiemTraDangNhap(
			String tenDangNhap, 
			String matKhau, ModelMap modelMap) {
		
		modelMap.addAttribute("tenDangNhap", tenDangNhap);
		modelMap.addAttribute("matKhau", matKhau);
		EnumDangNhap kiemTraDangNhap = nhanVienService.kiemTraDangNhap(tenDangNhap, matKhau);
		
		if (kiemTraDangNhap == EnumDangNhap.THANH_CONG) {
			//Nêú đăng nhập thành công thì tiến hành gửi session cho trang chủ 
			modelMap.addAttribute("email", tenDangNhap);
			
			return "thanh_cong";
		} 
		else if (kiemTraDangNhap == EnumDangNhap.USER_KO_TON_TAI) {
			return "user_ko_ton_tai";
		}
		return "sai_mat_khau";
	}
	
	
	@GetMapping("/ThemGioHang")
	@ResponseBody
	public String themGioHang(
		@RequestParam int maChiTietSanPham,
		@RequestParam int maSanPham,
		@RequestParam int maMau, 
		@RequestParam int maSize, 
		@RequestParam String tenSanPham, 
		@RequestParam String tenMau, 
		@RequestParam String tenSize, 
		@RequestParam String hinhSanPham,
		@RequestParam String giaTien, 
		@RequestParam int soLuong, 
		HttpSession httpSession) {
		
		if (httpSession.getAttribute("giohang") == null) {
			List<GioHang> listGioHang = new ArrayList<GioHang>();
			themDuLieuVaoGioHang(
					maChiTietSanPham,
					maSanPham,
					maMau, 
					maSize,
					tenSanPham,
					tenMau,
					tenSize,
					hinhSanPham,
					giaTien,
					1, //soLuong,
					listGioHang);
			httpSession.setAttribute("giohang", listGioHang);
		} else {
			List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
			int indexBiTrung = kiemTraTrung(maSanPham, maMau, maSize, listGioHang);
			if (indexBiTrung != -1) {
				int soLuongHienTai = listGioHang.get(indexBiTrung).getSoLuong();
				listGioHang.get(indexBiTrung).setSoLuong(soLuongHienTai + 1);
				
			} else {
				themDuLieuVaoGioHang(
						maChiTietSanPham,
						maSanPham, 
						maMau, 
						maSize, 
						tenSanPham, 
						tenMau, 
						tenSize, 
						hinhSanPham,
						giaTien, 
						1, 
						listGioHang);
			}
		}
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		return String.valueOf(listGioHang.size());
	}
	
	
	// Thêm dữ liệu vào list GioHang
	public void themDuLieuVaoGioHang(
			int maChiTietSanPham,
			int maSanPham,
			int maMau, 
			int maSize, 
			String tenSanPham, 
			String tenMau, 
			String tenSize, 
			String hinhSanPham,
			String giaTien, 
			int soLuong, List<GioHang> listGioHang) {
		GioHang gioHang = new GioHang();
		gioHang.setMaChiTietSanPham(maChiTietSanPham);
		gioHang.setMaSanPham(maSanPham);
		gioHang.setMaMau(maMau);
		gioHang.setMaSize(maSize);
		gioHang.setTenSanPham(tenSanPham);
		gioHang.setTenMau(tenMau);
		gioHang.setTenSize(tenSize);
		gioHang.setHinhSanPham(hinhSanPham);
		gioHang.setGiaTien(giaTien);
		gioHang.setSoLuong(soLuong);
		listGioHang.add(gioHang);
	}
	
	
	// Kiểm tra trước khi thêm gioHang vào listSanPham
	public int kiemTraTrung(int maSanPham, int maMau, int maSize, List<GioHang> listGioHang) {
		if (listGioHang == null) {
			return -1;
		}
		for (int i = 0; i < listGioHang.size(); i++) {
			if (listGioHang.get(i).getMaSanPham() == maSanPham 
					&& listGioHang.get(i).getMaMau() == maMau 
					&& listGioHang.get(i).getMaSize() == maSize) {
				return i;
			}
		}
		return -1;
	}
	
	
	@GetMapping("/SoLuongGioHang")
	@ResponseBody
	public String laySoLuongGioHang(HttpSession httpSession) {
		if (httpSession.getAttribute("giohang") == null) {
			return "";
		}

		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		return String.valueOf(listGioHang.size());
	}
	
	
	@GetMapping(path="/UpdateSoLuongGioHang")
	@ResponseBody
	public void updateSoLuongGioHang(HttpSession httpSession, 
		@RequestParam int soLuong, 
		@RequestParam int maSanPham, 
		@RequestParam int maMauSanPham, 
		@RequestParam int maSizeSanPham) {
		
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		int indexTrung = kiemTraTrung(maSanPham, maMauSanPham, maSizeSanPham, listGioHang);
		if (indexTrung != -1) {
			GioHang gioHang = listGioHang.get(indexTrung);
			gioHang.setSoLuong(soLuong);
		}
	}
	
	@GetMapping(path="/XoaSanPhamGioHang")
	@ResponseBody 
	public void xoaSanPhamGioHang(
		HttpSession httpSession,
		@RequestParam int maSanPham, 
		@RequestParam int maMauSanPham, 
		@RequestParam int maSizeSanPham) {
		if (httpSession.getAttribute("giohang") == null) {
			return;
		}
		List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohang");
		int indexDelete = kiemTraTrung(maSanPham, maMauSanPham, maSizeSanPham, listGioHang);
		listGioHang.remove(indexDelete);
	}
	
	public class SanPhamPage {
		private String hinhAnh;
		private String tenSanPham;
		private String giaTien;
		private String gianhCho;
		
		public SanPhamPage() { } 
		public SanPhamPage(String hinhAnh, String tenSanPham, String giaTien, String gianhCho) {
			this.hinhAnh = hinhAnh;
			this.tenSanPham = tenSanPham;
			this.giaTien = giaTien;
			this.gianhCho = gianhCho;
		}
		public String getHinhAnh() {
			return hinhAnh;
		}
		public void setHinhAnh(String hinhAnh) {
			this.hinhAnh = hinhAnh;
		}
		public String getTenSanPham() {
			return tenSanPham;
		}
		public void setTenSanPham(String tenSanPham) {
			this.tenSanPham = tenSanPham;
		}
		public String getGiaTien() {
			return giaTien;
		}
		public void setGiaTien(String giaTien) {
			this.giaTien = giaTien;
		}
		public String getGianhCho() {
			return gianhCho;
		}
		public void setGianhCho(String gianhCho) {
			this.gianhCho = gianhCho;
		}
	}
	@GetMapping(path="/PhanTrangSanPham",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String phanTranSanPham(
		@RequestParam(name="pagenumber") int pageNumber) {
		// Thực hiện chia 5 sản phẩm trên 1 page
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPham((pageNumber - 1) * 5, 5);
		
		// Thực hiển đổ dữ liệu sang SanPhamPage 
		List<SanPhamPage> listSanPhamPage = new ArrayList<APIController.SanPhamPage>();
		for (SanPham sp : listSanPham) {
			SanPhamPage spp = new SanPhamPage(sp.getHinhSanPham(), sp.getTenSanPham(), sp.getGiaTien(), sp.getGioiTinh());
			listSanPhamPage.add(spp);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        String arrayToJson = "";
		try {
			arrayToJson = objectMapper.writeValueAsString(listSanPhamPage);
		} catch (JsonProcessingException e) {
			System.out.println("có lỗi rồi");
		}
		return arrayToJson;
	}
}

