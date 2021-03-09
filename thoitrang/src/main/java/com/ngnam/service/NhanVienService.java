package com.ngnam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngnam.dao.NhanVienDAO;
import com.ngnam.dao_imp.NhanVienImp;
import com.ngnam.entity.EnumDangNhap;
import com.ngnam.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp{
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	
	
	public EnumDangNhap kiemTraDangNhap(String tenDangNhap, String matKhau) {
		return nhanVienDAO.kiemTraDangNhap(tenDangNhap, matKhau);
	}


	public boolean themNhanVien(NhanVien nhanVien) {
		return nhanVienDAO.themNhanVien(nhanVien);
		
	}
}
